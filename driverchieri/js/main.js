/* main.js - lightweight behaviors
   - debounce scroll for navbar class toggle
   - accessible navbar toggler aria handling
   - smooth scroll for internal links
   - init AOS
*/

document.addEventListener('DOMContentLoaded', function () {
  // Initialize AOS (assumes aos.js already loaded)
  if (window.AOS) AOS.init({ duration: 900, once: true });

  // Set footer year
  const yearEl = document.getElementById('currentYear');
  if (yearEl) yearEl.textContent = new Date().getFullYear();

  // NAVBAR: toggle "scrolled" class with debounce (better perf)
  const navbar = document.getElementById('mainNavbar');
  let lastKnownScroll = 0;
  let ticking = false;

  function onScroll() {
    lastKnownScroll = window.scrollY;
    if (!ticking) {
      window.requestAnimationFrame(function () {
        navbar.classList.toggle('scrolled', lastKnownScroll > 60);
        ticking = false;
      });
      ticking = true;
    }
  }
  window.addEventListener('scroll', onScroll, { passive: true });

  // Navbar toggler accessible aria-expanded sync
  const navToggle = document.getElementById('navToggle');
  const navMenu = document.getElementById('navMenu');
  if (navToggle && navMenu) {
    navToggle.addEventListener('click', function () {
      const expanded = this.getAttribute('aria-expanded') === 'true';
      this.setAttribute('aria-expanded', String(!expanded));
    });
    // close mobile menu when clicking a link (good UX)
    navMenu.addEventListener('click', function (e) {
      const target = e.target;
      if (target.matches('.nav-link')) {
        // use bootstrap collapse if available
        if (typeof bootstrap !== 'undefined') {
          const bsCollapse = bootstrap.Collapse.getInstance(navMenu) || new bootstrap.Collapse(navMenu);
          bsCollapse.hide();
          navToggle.setAttribute('aria-expanded', 'false');
        }
      }
    });
  }

  // Smooth scroll for internal anchor links (simple and performant)
  document.querySelectorAll('a[href^="#"]').forEach(function (anchor) {
    anchor.addEventListener('click', function (e) {
      const href = this.getAttribute('href');
      // only handle internal links with hash
      if (href && href.startsWith('#') && href.length > 1) {
        const target = document.querySelector(href);
        if (target) {
          e.preventDefault();
          target.scrollIntoView({ behavior: 'smooth', block: 'start' });
        }
      }
    });
  });

  // Optional: lazy image error handling (replace missing images with placeholder)
  document.querySelectorAll('img').forEach(img => {
    img.addEventListener('error', () => {
      img.src = 'images/placeholder.png'; // create a small placeholder in your images folder
    });
  });

});

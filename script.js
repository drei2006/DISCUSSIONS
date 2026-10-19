  // PERSONALIZE THIS OBJECT before presenting your website.
const profile = {
  name: "Keith Marten Alaan",
  email: "keithalaan7@gmail.com"
};

document.querySelectorAll("[data-name]").forEach(el => el.textContent = profile.name);
document.title = `${profile.name} | Personal Portfolio`;
document.getElementById("emailLink").href = `mailto:${profile.email}`;
document.getElementById("emailText").textContent = profile.email;
document.getElementById("emailText").href = `mailto:${profile.email}`;
document.getElementById("year").textContent = new Date().getFullYear();

// Mobile navigation
const menuToggle = document.getElementById("menuToggle");
const navMenu = document.getElementById("navMenu");
menuToggle.addEventListener("click", () => {
  const open = navMenu.classList.toggle("open");
  menuToggle.setAttribute("aria-expanded", String(open));
  menuToggle.textContent = open ? "×" : "☰";
});
navMenu.querySelectorAll("a").forEach(link => link.addEventListener("click", () => {
  navMenu.classList.remove("open");
  menuToggle.setAttribute("aria-expanded", "false");
  menuToggle.textContent = "☰";
}));

// Theme switch with preference kept for this browser session.
const themeToggle = document.getElementById("themeToggle");
themeToggle.addEventListener("click", () => {
  document.body.classList.toggle("light-theme");
  const light = document.body.classList.contains("light-theme");
  themeToggle.textContent = light ? "☀" : "☾";
  showToast(light ? "Light mode enabled ☀" : "Dark mode enabled ☾");
});

// Reveal cards as they enter the screen.
const revealObserver = new IntersectionObserver(entries => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      entry.target.classList.add("visible");
      revealObserver.unobserve(entry.target);
    }
  });
}, { threshold: 0.12 });
document.querySelectorAll(".reveal").forEach(el => revealObserver.observe(el));

// Update active navigation section.
const sectionObserver = new IntersectionObserver(entries => {
  entries.forEach(entry => {
    if (entry.isIntersecting) {
      document.querySelectorAll(".nav-link").forEach(a => {
        a.classList.toggle("active", a.getAttribute("href") === `#${entry.target.id}`);
      });
    }
  });
}, { rootMargin: "-30% 0px -60% 0px" });
document.querySelectorAll("main section[id]").forEach(section => sectionObserver.observe(section));

// Hobby cards open an accessible detail dialog.
const hobbyDetails = {
  coding: { symbol: "</>", title: "Coding & creating", body: "I like the feeling of turning an idea into something that actually works. Every bug is a chance to think differently, practice patience, and learn a new technique." },
  music: { symbol: "♫", title: "Music for every mood", body: "Music helps me focus while studying, recharge after a busy day, and make ordinary moments feel special. The right playlist can change the whole vibe." },
  gaming: { symbol: "⌘", title: "Gaming & strategy", body: "Games are a fun mix of creativity, quick decisions, teamwork, and persistence. I enjoy the challenge of improving a little each time I play." },
  learning: { symbol: "✧", title: "Always learning", body: "I enjoy exploring topics I don't know yet. Whether it's a new tool or a better way to solve a problem, I believe curiosity is a skill worth keeping." },
  friends: { symbol: "☻", title: "Good people, good memories", body: "Spending time with friends reminds me that life isn't only about tasks and deadlines. Sharing stories, laughs, and new experiences matters too." }
};
const hobbyDialog = document.getElementById("hobbyDialog");
document.querySelectorAll("[data-hobby]").forEach(card => card.addEventListener("click", () => {
  const detail = hobbyDetails[card.dataset.hobby];
  document.getElementById("dialogSymbol").textContent = detail.symbol;
  document.getElementById("dialogTitle").textContent = detail.title;
  document.getElementById("dialogBody").textContent = detail.body;
  hobbyDialog.showModal();
}));
document.getElementById("dialogClose").addEventListener("click", () => hobbyDialog.close());
document.getElementById("dialogOkay").addEventListener("click", () => hobbyDialog.close());
hobbyDialog.addEventListener("click", event => {
  if (event.target === hobbyDialog) hobbyDialog.close();
});

// A small rotating fact makes the page worth exploring.
const facts = [
  "I believe small improvements can lead to big results.",
  "The best way to learn is to build something and experiment.",
  "A good playlist makes study sessions feel a little easier.",
  "Every expert was once a beginner.",
  "Curiosity turns an ordinary question into a new idea."
];
let factIndex = 0;
document.getElementById("factButton").addEventListener("click", () => {
  factIndex = (factIndex + 1) % facts.length;
  const fact = document.getElementById("funFact");
  fact.animate([{opacity:0, transform:"translateY(5px)"},{opacity:1, transform:"translateY(0)"}], {duration:260});
  fact.textContent = facts[factIndex];
});

let toastTimer;
function showToast(message) {
  const toast = document.getElementById("toast");
  toast.textContent = message;
  toast.classList.add("show");
  clearTimeout(toastTimer);
  toastTimer = setTimeout(() => toast.classList.remove("show"), 1800);
}

// Helpful keyboard behavior for dialogs.
document.addEventListener("keydown", event => {
  if (event.key === "Escape" && hobbyDialog.open) hobbyDialog.close();
});

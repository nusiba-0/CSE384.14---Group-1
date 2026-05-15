(function () {
   const raw = localStorage.getItem('meowwoof_user');
   if (!raw) {
       // Not logged in — redirect to auth page
       window.location.href = 'auth.html';
       return;
   }


   try {
       const user = JSON.parse(raw);
       const role = user.role || 'volunteer';


       document.getElementById('userAvatar').textContent    = role === 'vet' ? '🩺';
       document.getElementById('userName').textContent      = user.name || 'User';
       document.getElementById('userRoleBadge').textContent = role === 'vet' ? 'Vet' : 'Volunteer';
       document.getElementById('userRoleBadge').className   = 'user-role-badge role-' + role;
   } catch (e) {
       window.location.href = 'auth.html';
   }
})();


function logout() {
   if (confirm('Sign out of MeowWoof?')) {
       localStorage.removeItem('meowwoof_user');
       window.location.href = 'auth.html';
   }
}

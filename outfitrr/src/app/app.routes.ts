import { Routes } from '@angular/router';
import { Recommend } from './pages/recommend/recommend';
import { Login } from './pages/login/login';
import { Register } from './pages/register/register';
import { authGuard } from './guards/auth-guard';
import { Front } from './pages/front/front';
import { SavedOutfits } from './pages/saved-outfits/saved-outfits';

export const routes: Routes = [
  { path: 'login', component: Login },

  { path: 'front', component: Front },

  { path: 'register', component: Register },

  { path: 'recommend', component: Recommend , canActivate: [authGuard]},

  { path:'saved-outfits', component:SavedOutfits, canActivate:[authGuard] },

  { path: '', redirectTo: 'front', pathMatch: 'full' }
];

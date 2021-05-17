import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewRequestComponent } from './new-request/new-request.component';
import { RequestsComponent } from './requests/requests.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: '/requests',
    pathMatch: 'full'
  },  
  {
    path: 'requests',
    component: RequestsComponent
  },
  {
    path: 'new-request',
    component: NewRequestComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

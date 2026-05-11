import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { Clients } from './clients/clients';
import { Contracts } from './contracts/contracts';
import { NewClient } from './new-client/new-client';
import { Payments } from './payments/payments';

const routes: Routes = [
  { path: 'clients', component: Clients },
  { path: 'contracts', component: Contracts },
  { path: 'new-client', component: NewClient },
  { path: 'payments/:contractId', component: Payments },
  { path: '', redirectTo: '/clients', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

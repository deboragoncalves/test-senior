import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { NewPersonComponent } from './new-person/new-person.component';

const routes: Routes = [
  { path: 'person', component: NewPersonComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

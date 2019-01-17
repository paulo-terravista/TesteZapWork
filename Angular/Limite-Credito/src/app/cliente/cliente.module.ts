import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule} from '@angular/common';
import { ClienteComponent } from './form/cliente.component';
import { ClienteService } from './service/cliente.service';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    
  ],
  declarations: [ClienteComponent,],
  exports: [
    ClienteComponent
  ],
  providers: [
    ClienteService
  ]
})
export class ClienteModule { }

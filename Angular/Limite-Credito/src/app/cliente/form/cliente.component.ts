import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import 'rxjs/Rx';

import { ClienteModel } from '../model/cliente.model';
import { ClienteService } from '../service/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  

  clienteForm: FormGroup;
  txNomeCliente: FormControl;
  nmLimiteCredito: FormControl;
  slRisco: FormControl;

  clienteModel: ClienteModel;
  listCliente: ClienteModel[];

  mostrarMensagem = false;
  mostrarSucesso = false;
  mostrarErro = false;


  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
    this.preparaFormGroup();
    this.listCliente = [];
    
    this.clienteService.listAllCliente()
        .pipe()
        .take(1)
        .subscribe((lista: ClienteModel[]) => this.listCliente = lista);
  }


  private preparaFormGroup() {
    this.clienteModel = {
      nome: '',
      limiteCredito: 0,
      risco: 'A'
    };
    this.txNomeCliente = new FormControl(this.clienteModel.nome, Validators.required);
    this.nmLimiteCredito = new FormControl(this.clienteModel.limiteCredito, Validators.required);
    this.slRisco = new FormControl(this.clienteModel.risco, Validators.required);
    this.clienteForm = new FormGroup({
      txNomeCliente: this.txNomeCliente,
      nmLimiteCredito: this.nmLimiteCredito,
      slRisco: this.slRisco
    });
  }

  save() {
    this.mostrarMensagem = true;
    this.closeMensagem();
    if (this.clienteForm.valid) {
      this.clienteModel = {
        nome: this.clienteForm.value.txNomeCliente,
        limiteCredito: this.clienteForm.value.nmLimiteCredito,
        risco: this.clienteForm.value.slRisco
     }
     this.clienteService.saveCliente(this.clienteModel)
          .pipe()
          .take(1)
          .subscribe(value => this.processSucessoGravacao(),
                     error => {
                       console.log(error)
                       this.mostrarErro = true
                     });
    }
  }

  private processSucessoGravacao(): boolean {
    this.listCliente = [];
    
    this.clienteForm.reset({ 
      txNomeCliente: '',
      nmLimiteCredito: 0,
      slRisco: 'A'
    });

    this.clienteService.listAllCliente()
        .pipe()
        .take(1)
        .subscribe((lista: ClienteModel[]) => this.listCliente = lista);

    return this.mostrarSucesso = true;
  }

  closeMensagem() {
    this.mostrarSucesso = false;
    this.mostrarErro = false;
  }
}

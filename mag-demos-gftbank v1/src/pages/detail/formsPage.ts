import { Component } from '@angular/core';
import { Validators, FormBuilder, FormGroup } from '@angular/forms';
@Component({
  template: `
    <form [formGroup]="todo" (ngSubmit)="logForm()">
      <ion-item>
        <ion-label floating>Todo</ion-label>
        <ion-input type="text" formControlName="nombre"></ion-input>
      </ion-item>
      <ion-item>
        <ion-label floating>Todo</ion-label>
        <ion-input type="text" formControlName="apellidos"></ion-input>
      </ion-item>      
      <ion-item>
        <ion-label floating>Domicilio</ion-label>
        <ion-textarea formControlName="domicilio"></ion-textarea>
      </ion-item>
      <button ion-button block type="submit" [disabled]="!todo.valid">Guardar</button>
    </form>
  `
})
export class FormsPage {
  private todo : FormGroup;

  constructor( private formBuilder: FormBuilder ) {
    this.todo = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellidos: ['', Validators.required],
      domicilio: ['']
    });
  }
  logForm(){
    console.log(this.todo.value)
  }
}
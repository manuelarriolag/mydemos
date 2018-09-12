import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';
import { DetailPage } from '../detail/detail';
import { ClientesAdminProvider, Cliente } from '../../providers/ClientesAdminProvider/ClientesAdminProvider';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  clientes: Cliente[];

  constructor(public navCtrl: NavController, public provider:ClientesAdminProvider) {
  }

  showDetail(cliente: Cliente){
    this.navCtrl.push(DetailPage, {
      item: cliente
    });
  }

  ionViewDidLoad() {
    this.provider.getList()
      .subscribe(
        (data) => {this.clientes = data},
        (error) => {console.error(error)}
      );
  }


}

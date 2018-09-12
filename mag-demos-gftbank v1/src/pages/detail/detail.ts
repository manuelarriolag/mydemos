import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, ActionSheetController, Platform, ViewController, AlertController } from 'ionic-angular';
import { Cliente, ClientesAdminProvider } from '../../providers/ClientesAdminProvider/ClientesAdminProvider';
import { HomePage } from '../home/home';
//import { FormBuilder, FormGroup, Validators, AbstractControl } from '@angular/forms';

@IonicPage()
@Component({
  selector: 'page-detail',
  templateUrl: 'detail.html',
})
export class DetailPage {
  item: Cliente = {} as Cliente;
  isNew: boolean = true;
  action: string = 'Agregar';
  result: any = {};

  //yForm: FormGroup; 
 
  constructor(
      public alertCtrl: AlertController,
      public viewCtrl: ViewController,
      public navCtrl: NavController,
      public navParams: NavParams, 
      public actionSheetCtrl: ActionSheetController,
      public platform: Platform,
      public provider: ClientesAdminProvider
    ) {
      // do nothing
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad DetailPage');

    let editItem = this.navParams.get('item');
    if (editItem){
      this.isNew = false;
      this.item = editItem;
      this.action = 'Editar';
    }
  }

  
  submit() {
    console.log(this.item);

    let newItem = {} as Cliente;
    newItem.nombre = this.item.nombre;
    newItem.apellidos = this.item.apellidos;
    newItem.domicilio = this.item.domicilio;
    
    if (this.isNew) {
 
        this.provider.add(newItem)
          .subscribe(
            (data) => {
              this.result = data

              console.log(data)

              this.dismiss();

              this.navCtrl.setRoot(HomePage);

            },
            (error) => {console.error(error)}
          );
    } else {
        newItem.id = this.item.id;
        this.provider.update(newItem)
          .subscribe(
            (data) => {
              this.result = data

              console.log(data)

              this.dismiss();

              this.navCtrl.setRoot(HomePage);

            },
            (error) => {console.error(error)}
            );
    }
  }

  delete() {
    let alert = this.alertCtrl.create({
      title: 'Confirmar Eliminación',
      message: '¿Está seguro que desea ELIMINAR este registro?',
      buttons: [
        {
          text: 'Cancelar',
          role: 'cancel',
          handler: () => {
            console.log('Cancelar clicked');
          }
        },
        {
          text: 'Eliminar',
          handler: () => {
            console.log('Eliminar clicked');
            
            // user has clicked the ELIMINAR button
            // begin the alert's dismiss transition
            let navTransition = alert.dismiss();

            // start some async method
            this.provider.delete(this.item.id)
              .subscribe(
                (data) => {
                  this.result = data

                  console.log(data)

                  // once the async operation has completed
                  // then run the next nav transition after the
                  // first transition has finished animating out
                  navTransition.then(() => {
                    this.navCtrl.setRoot(HomePage);
                  });

                  this.dismiss();

                },
                (error) => {console.error(error)}
              );

            return false;

          }
        }
      ]
    });
    alert.present();



  }

  dismiss() {
      this.viewCtrl.dismiss(this.item);
  }

  // openMenu() {
  //   let actionSheet = this.actionSheetCtrl.create({
  //     title: 'Acciones para Clientes',
  //     cssClass: 'page-detail', // TODO No estan haciendo match los estilos
  //     buttons: [
  //       {
  //         text: 'Guardar cambios',
  //         icon: !this.platform.is('ios') ? 'cloud-upload' : null,
  //         handler: () => {
  //           console.log('Guardar cambios presionado');

  //           // // user has clicked the action sheet button
  //           // // begin the action sheet's dimiss transition
  //           // let navTransition = actionSheet.dismiss();

  //           // // start some async method
  //           // saveAsyncOperation().then(() => {
  //           //     // once the async operation has completed
  //           //     // then run the next nav transition after the
  //           //     // first transition has finished animating out

  //           //     navTransition.then(() => {
  //           //         this.navCtrl.pop();
  //           //     });
  //           // });
  //           // return false;
            
  //         }
  //       },
  //       {
  //         text: 'Eliminar registro',
  //         role: 'destructive',
  //         icon: !this.platform.is('ios') ? 'trash' : null,
  //         handler: () => {
  //           console.log('Eliminar clicked');
  //         }
  //       },
  //       // {
  //       //   text: 'Favorite',
  //       //   icon: !this.platform.is('ios') ? 'heart-outline' : null,
  //       //   handler: () => {
  //       //     console.log('Favorite clicked');
  //       //   }
  //       // },
  //       {
  //         text: 'Cancelar',
  //         role: 'cancel', // will always sort to be on the bottom
  //         icon: !this.platform.is('ios') ? 'close' : null,
  //         handler: () => {
  //           console.log('Cancelar clicked');
  //         }
  //       }
  //     ]
  //   });
  //   actionSheet.present();
  // }

}



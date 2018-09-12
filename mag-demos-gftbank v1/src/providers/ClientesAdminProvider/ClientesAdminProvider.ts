import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

const API: string = "http://api-srv:8080/api";

export interface Cliente {
  apellidos: string;
  domicilio: string;
  id: string;
  nombre: string;
}

export interface ClienteListResponse{
  list: Cliente[],
  message: string;
  ok: boolean;
  status: number;
  statusText:	string;
}

@Injectable()
export class ClientesAdminProvider {

  //lastResult: any;

  constructor(public http: HttpClient) {
    console.log('Se ha cargado el proveedor del API REST ClientesAdmin');
  }

  getList(): Observable<Cliente[]>{
    let url = API + '/clientes/';
    return this.http.get<{list: Cliente[]}>(url)
      .map(res => {
        console.log('Revisando resultados de getList()');
        if (res.list.length == 0){
          return null;
        }
        return res.list;
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getList(), no se tienen mas detalles.');
      });
  }

  getByNombre(nombre: string): Observable<Cliente>{
    let url = API + '/clientes?nombre=' + nombre;
    return this.http.get<{list: Cliente[]}>(url)
      .map(res => {
        console.log('Revisando resultados de getByNombre()');
        if (res.list.length == 0){
          return null;
        }
        return res.list[0];
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getByNombre(), no se tienen mas detalles.');
      });
  }

  getById(id: string): Observable<Cliente>{
    let url = API + '/clientes/' + id;
    return this.http.get<{list: Cliente[]}>(url)
      .map(res => {
        console.log('Revisando resultados de getById()');
        if (res.list.length == 0){
          return null;
        }
        return res.list[0];
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getById(), no se tienen mas detalles.');
      });
  }

  delete(id: string): Observable<any> {
    let url = API + '/clientes/' + id;
    return this.http.delete<{ok: boolean, message: string}>(url)
      .map(res => {
        console.log('Revisando resultados de delete()');
        if (!res.ok){
          console.error('No se pudo ELIMINAR el registro solicitado: ' + res.message);
          return "No se pudo ELIMINAR el registro solicitado.";
        }
        return res.message;
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getById(), no se tienen mas detalles.');
      });
  }

  update(item: Cliente): Observable<any> {

    let url = API + '/clientes/' + item.id;
    // let httpOptions = {
    //     headers: new HttpHeaders({
    //         'enctype': 'multipart/form-data; boundary=----WebKitFormBoundaryuL67FWkv1CA'
    //     })
    // };
    
    // let formData = new FormData();
    // formData.append("id", item.id);
    // formData.append("nombre", item.nombre);
    // formData.append("apellidos", item.apellidos);
    // formData.append("domicilio", item.domicilio);
    //return this.http.put<{ok: boolean, message: string}>(url, formData, httpOptions)

    return this.http.put<{ok: boolean, message: string}>(url, item)
      .map(res => {
        console.log('Revisando resultados de update()');
        if (!res.ok){
          console.error('No se pudo ACTUALIZAR el registro solicitado: ' + res.message);
          return "No se pudo ACTUALIZAR el registro solicitado.";
        }
        return res.message;
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getById(), no se tienen mas detalles.');
      });  
  }

  add(item: Cliente): Observable<any> {

    let url = API + '/clientes';
    // let httpOptions = {
    //     headers: new HttpHeaders({
    //         'enctype': 'multipart/form-data; boundary=----WebKitFormBoundaryuL67FWkv1CA'
    //     })
    // };
    
    // let formData = new FormData();
    // formData.append("nombre", item.nombre);
    // formData.append("apellidos", item.apellidos);
    // formData.append("domicilio", item.domicilio);
    //return this.http.post<{ok: boolean, message: string}>(url, formData, httpOptions)

    return this.http.post<{ok: boolean, message: string}>(url, item)
      .map(res => {
        console.log('Revisando resultados de add()');
        if (!res.ok){
          console.error('No se pudo CREAR el registro solicitado: ' + res.message);
          return "No se pudo CREAR el registro solicitado.";
        }
        return res.message;
      })
      .catch(err => {
        return Observable.throw(err || 'Error en el servidor al ejecutar getById(), no se tienen mas detalles.');
      });  
  }


}

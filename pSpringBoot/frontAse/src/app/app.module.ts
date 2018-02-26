import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from "@angular/forms";
import { HttpModule } from "@angular/http";

// rutas
import {APP_ROUTING} from "./app.routes";

//servicios

//Componentes
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar/navbar.component';
import { FooterComponent } from './components/navbar/footer/footer.component';
import { PersonaComponent } from './components/registro/persona/persona.component';
import { ClienteComponent } from './components/registro/cliente/cliente.component';
import { ProveedorComponent } from './components/registro/proveedor/proveedor.component';
import { EntradamaderarolloComponent } from './components/madera.en.rollo/entradamaderarollo/entradamaderarollo.component';
import { SalidamaderarolloComponent } from './components/madera.en.rollo/salidamaderarollo/salidamaderarollo.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavbarComponent,
    FooterComponent,
    PersonaComponent,
    ClienteComponent,
    ProveedorComponent,
    EntradamaderarolloComponent,
    SalidamaderarolloComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    APP_ROUTING
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

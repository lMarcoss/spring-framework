import { RouterModule, Routes } from "@angular/router";
import { HomeComponent } from "./components/home/home.component";
import { PersonaComponent } from "./components/registro/persona/persona.component";
import { ClienteComponent } from "./components/registro/cliente/cliente.component";
import {EntradamaderarolloComponent} from "./components/madera.en.rollo/entradamaderarollo/entradamaderarollo.component";
import {SalidamaderarolloComponent} from "./components/madera.en.rollo/salidamaderarollo/salidamaderarollo.component";
import {ProveedorComponent} from "./components/registro/proveedor/proveedor.component";

const APP_ROUTES: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'cliente', component: ClienteComponent },
  { path: 'persona', component: PersonaComponent },
  { path: 'proveedor', component: ProveedorComponent },
  { path: 'entradamaderarollo', component: EntradamaderarolloComponent },
  { path: 'salidamaderarollo', component: SalidamaderarolloComponent },
  { path: '', pathMatch: 'full', redirectTo: 'home'}
];

export const APP_ROUTING = RouterModule.forRoot(APP_ROUTES, {useHash: true});

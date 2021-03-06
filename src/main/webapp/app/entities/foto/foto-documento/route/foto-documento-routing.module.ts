import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { FotoDocumentoComponent } from '../list/foto-documento.component';
import { FotoDocumentoDetailComponent } from '../detail/foto-documento-detail.component';
import { FotoDocumentoUpdateComponent } from '../update/foto-documento-update.component';
import { FotoDocumentoRoutingResolveService } from './foto-documento-routing-resolve.service';
import { FotoDocumentoRoutingResolvePessoaService } from './foto-documento-routing-resolve-personal.service';

const fotoDocumentoRoute: Routes = [
  {
    path: '',
    component: FotoDocumentoComponent,
    data: {
      defaultSort: 'id,asc',
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'documento/:idDocumento',
    component: FotoDocumentoComponent,
    data: {
      defaultSort: 'id,asc',
    },
    resolve: {
      documento: FotoDocumentoRoutingResolvePessoaService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/view',
    component: FotoDocumentoDetailComponent,
    resolve: {
      fotoDocumento: FotoDocumentoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new',
    component: FotoDocumentoUpdateComponent,
    resolve: {
      fotoDocumento: FotoDocumentoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: 'new/documento/:idDocumento',
    component: FotoDocumentoUpdateComponent,
    resolve: {
      fotoDocumento: FotoDocumentoRoutingResolveService,
      documento: FotoDocumentoRoutingResolvePessoaService,
    },
    canActivate: [UserRouteAccessService],
  },
  {
    path: ':id/edit',
    component: FotoDocumentoUpdateComponent,
    resolve: {
      fotoDocumento: FotoDocumentoRoutingResolveService,
    },
    canActivate: [UserRouteAccessService],
  },
];

@NgModule({
  imports: [RouterModule.forChild(fotoDocumentoRoute)],
  exports: [RouterModule],
})
export class FotoDocumentoRoutingModule {}

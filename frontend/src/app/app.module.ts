import { ComponentsModule } from './components/components.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DeckModule } from './deck/deck.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
//import { SocialLoginModule, AuthServiceConfig } from 'angular5-social-login';
import { SigninComponentComponent, getAuthServiceConfigs } from './signin-component/signin-component.component';

import { AngularFireModule } from '@angular/fire';
import { AngularFireDatabaseModule } from '@angular/fire/database';
import { AngularFirestoreModule } from '@angular/fire/firestore';
import { AngularFireStorageModule } from '@angular/fire/storage';
import { AngularFireAuthModule } from '@angular/fire/auth';
import { AngularFireFunctionsModule } from '@angular/fire/functions';

import { environment } from '../environments/environment';
import { HomeComponent } from './home/home.component';
import { MenuComponent } from './menu/menu.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SocialLoginModule, AuthServiceConfig } from "angularx-social-login";
import { LoginComponent } from './login/login.component';



@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MenuComponent,
    PageNotFoundComponent,
    SigninComponentComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    ComponentsModule,
    HttpClientModule,
    SocialLoginModule,
    AppRoutingModule,
    DeckModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    AngularFireDatabaseModule,
    AngularFirestoreModule, // firestore
    AngularFireAuthModule, // auth
    AngularFireStorageModule, // storage
    AngularFireFunctionsModule,
  ],
  providers: [
    CookieService,
    {
      provide: AuthServiceConfig,
      useFactory: getAuthServiceConfigs
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

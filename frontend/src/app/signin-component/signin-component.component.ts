import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
/*import {
  AuthService,
  FacebookLoginProvider,
  GoogleLoginProvider,
  AuthServiceConfig
} from 'angular5-social-login';*/

import { SocialLoginModule, AuthServiceConfig, AuthService } from 'angularx-social-login';
import { GoogleLoginProvider, FacebookLoginProvider, LinkedInLoginProvider } from 'angularx-social-login';
import { SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-signin-component',
  templateUrl: './signin-component.component.html',
  styleUrls: ['./signin-component.component.scss']
})
export class SigninComponentComponent implements OnInit {

  userImageUrl: String;
  private user: SocialUser;
  private _loggedIn: boolean;

  public get loggedIn() {
    return this._loggedIn;
  }

  public set loggedIn(logged: boolean) {
    this._loggedIn = logged;
  }

  constructor(private authService: AuthService, private http: HttpClient) { }

  ngOnInit() {
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
    });
  }

  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
  }

  signInWithFB(): void {
    this.authService.signIn(FacebookLoginProvider.PROVIDER_ID);
  }

  signInWithLinkedIn(): void {
    this.authService.signIn(LinkedInLoginProvider.PROVIDER_ID);
  }

  signOut(): void {
    this.authService.signOut();
  }

  public socialSignIn(socialPlatform: string) {
    let socialPlatformProvider;
    if (socialPlatform === 'facebook') {
      socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    } else if (socialPlatform === 'google') {
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }

    this.authService.signIn(socialPlatformProvider).then(
      (userData) => {
        console.log(socialPlatform + 'sign in data :', userData);
        // Now sign-in with userData
        this.user = userData;
        this.userImageUrl = userData.photoUrl;
        this.loggedIn = (userData != null);

        //this.sendToRestApiMethod(userData.authToken);


      }
    );
  }

  public socialSignOut() {
/*
    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);

      console.log(" sign in authState : ", user);
    });*/
/*
    this.authService.signOut().then((userData) => {
      console.log(" sign out data : ", userData);
      this.loggedIn = false;
    });*/

    this.authService.signOut();
    this.loggedIn = false;

    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);

      console.log(" sign in authState : ", user);
    });

    this.authService.readyState.subscribe((user) => {
      //this.user = user;
      this.loggedIn = (user != null);

      console.log(" sign in readyState : ", user);
    });

  }

  public facebookLogin() {
    let socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    this.authService.signIn(socialPlatformProvider).then(
      (userData) => {
        //this will return user data from facebook. What you need is a user token which you will send it to the server
        this.sendToRestApiMethod(userData.authToken);
      }
    );
  }

  sendToRestApiMethod(token: string): void {
    this.http.post('url to facebook login here', { token: token })
      .subscribe(
        onSuccess => {
          console.log('sucesso')
          //login was successful
          //save the token that you got from your REST API in your preferred location i.e. as a Cookie or LocalStorage as you do with normal login
        }, onFail => {
          console.log('falha')
          //login was unsuccessful
          //show an error message
        }
      );
  }

}

export function getAuthServiceConfigs() {
  let config = new AuthServiceConfig(
    [
      {
        id: FacebookLoginProvider.PROVIDER_ID,
        provider: new FacebookLoginProvider("972616062945910") //("Your-Facebook-app-id")//"{FACEBOOK_APP_ID_HERE}"
      },
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider("Your-Google-Client-Id")
      },
    ]
  );
  return config;
}

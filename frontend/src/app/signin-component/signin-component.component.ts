import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import {
  AuthService,
  FacebookLoginProvider,
  GoogleLoginProvider,
  AuthServiceConfig
} from 'angular5-social-login';

@Component({
  selector: 'app-signin-component',
  templateUrl: './signin-component.component.html',
  styleUrls: ['./signin-component.component.scss']
})
export class SigninComponentComponent implements OnInit {

  constructor( private socialAuthService: AuthService, private http: HttpClient ) {}

  ngOnInit() {
  }

  public socialSignIn(socialPlatform : string) {
    let socialPlatformProvider;
    if(socialPlatform == "facebook"){
      socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    }else if(socialPlatform == "google"){
      socialPlatformProvider = GoogleLoginProvider.PROVIDER_ID;
    }

    this.socialAuthService.signIn(socialPlatformProvider).then(
      (userData) => {
        console.log(socialPlatform+" sign in data : " , userData);
        // Now sign-in with userData


      }
    );
  }

  public facebookLogin() {
    let socialPlatformProvider = FacebookLoginProvider.PROVIDER_ID;
    this.socialAuthService.signIn(socialPlatformProvider).then(
    (userData) => {
            //this will return user data from facebook. What you need is a user token which you will send it to the server
            this.sendToRestApiMethod(userData.token);
        }
    );
  }

  sendToRestApiMethod(token: string) : void {
    this.http.post('url to facebook login here', { token: token } )
        .subscribe(
            onSuccess => {
                    //login was successful
                    //save the token that you got from your REST API in your preferred location i.e. as a Cookie or LocalStorage as you do with normal login
            }, onFail => {
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
          provider: new FacebookLoginProvider("Your-Facebook-app-id")//"{FACEBOOK_APP_ID_HERE}"
        },
        {
          id: GoogleLoginProvider.PROVIDER_ID,
          provider: new GoogleLoginProvider("Your-Google-Client-Id")
        },
      ]
  );
  return config;
}

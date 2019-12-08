import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { AngularFireAuth } from '@angular/fire/auth';
import * as firebase from 'firebase/app';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;
  phoneNumber: string;
  code: String;
  window =  {recaptchaVerifier:null, confirmationResult:null };

  constructor(private http: HttpClient, private router:Router,public afAuth: AngularFireAuth) { }

  ngOnInit() {
  }

  public socialSignOut() {

  }

  loginWithFacebook() {
    this.afAuth.auth.signInWithPopup(new firebase.auth.FacebookAuthProvider()).then((result) => {
      // This gives you a Google Access Token. You can use it to access the Google API.
      var token = (<any>result).credential.accessToken;
      // The signed-in user info.
      //var user = result.user;
      // ...
    }).catch((error)=> {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      // The email of the user's account used.
      var email = error.email;
      // The firebase.auth.AuthCredential type that was used.
      var credential = error.credential;
      // ...
      console.log(error)
    });
    //console.log(this.afAuth.authState)
  }

  loginWithGoogle() {
    this.afAuth.auth.signInWithPopup(new firebase.auth.GoogleAuthProvider()).then((result) => {
      // This gives you a Google Access Token. You can use it to access the Google API.
      var token = (<any>result).credential.accessToken;
      // The signed-in user info.
      //var user = result.user;
      // ...
    }).catch((error) =>{
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      // The email of the user's account used.
      var email = error.email;
      // The firebase.auth.AuthCredential type that was used.
      var credential = error.credential;
      // ...
      console.log(error)
    });
    //console.log(this.afAuth.authState)
  }

  createUser(){

    this.afAuth.auth.createUserWithEmailAndPassword(this.email, this.password).catch((error)=> {
      // Handle Errors here.
      var errorCode = error.code;
      var errorMessage = error.message;
      // ...
    });

  }

  signInWithPhone(){
    console.log("onSignInSubmit")
    //var phoneNumber = '+5561999535840';
    var appVerifier = this.window.recaptchaVerifier;
    this.afAuth.auth.signInWithPhoneNumber(this.phoneNumber, appVerifier)
        .then((confirmationResult) => {
          // SMS sent. Prompt user to type the code from the message, then sign the
          // user in with confirmationResult.confirm(code).
          this.window.confirmationResult = confirmationResult;
        }).catch((error) => {
          // Error; SMS not sent
          // ...
          // grecaptcha.reset(window.recaptchaWidgetId);

          // // Or, if you haven't stored the widget ID:
          // this.window.recaptchaVerifier.render().then(function(widgetId) {
          //   grecaptcha.reset(widgetId);
          // })
          console.log(error)
        });
  }

  signInWithPhoneCode(){

    //let code = '029505'//getCodeFromUserInput();
    this.window.confirmationResult.confirm(this.code).then((result) =>{
      // User signed in successfully.
      let user = result.user;
      // ...
    }).catch((error) =>{
      // User couldn't sign in (bad verification code?)
      // ...
      console.log(error)
    });

  }

}

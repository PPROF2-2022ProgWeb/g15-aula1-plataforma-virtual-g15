import { Component, Inject } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  title = 'app';

  langs: string[] = [];

  constructor(private translate: TranslateService) {
    // this language will be used as a fallback when a translation isn't found in the current language
    this.translate.setDefaultLang('es');
     // the lang to use, if the lang isn't available, it will use the current loader to get them
     this.translate.use('es');
     this.translate.addLangs(['es', 'en']);
     this.langs = this.translate.getLangs();
  }

  changeLang(lang:string){
    this.translate.use(lang);
  }
}

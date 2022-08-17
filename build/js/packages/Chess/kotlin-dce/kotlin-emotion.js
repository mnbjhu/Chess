(function (root, factory) {
  if (typeof define === 'function' && define.amd)
    define(['exports', 'kotlin', 'kotlin-csstype', 'kotlin-extensions', '@emotion/css', '@emotion/styled'], factory);
  else if (typeof exports === 'object')
    factory(module.exports, require('kotlin'), require('kotlin-csstype'), require('kotlin-extensions'), require('@emotion/css'), require('@emotion/styled'));
  else {
    if (typeof kotlin === 'undefined') {
      throw new Error("Error loading module 'kotlin-emotion'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'kotlin-emotion'.");
    }
    if (typeof this['kotlin-csstype'] === 'undefined') {
      throw new Error("Error loading module 'kotlin-emotion'. Its dependency 'kotlin-csstype' was not found. Please, check whether 'kotlin-csstype' is loaded prior to 'kotlin-emotion'.");
    }
    if (typeof this['kotlin-extensions'] === 'undefined') {
      throw new Error("Error loading module 'kotlin-emotion'. Its dependency 'kotlin-extensions' was not found. Please, check whether 'kotlin-extensions' is loaded prior to 'kotlin-emotion'.");
    }
    if (typeof this['@emotion/css'] === 'undefined') {
      throw new Error("Error loading module 'kotlin-emotion'. Its dependency '@emotion/css' was not found. Please, check whether '@emotion/css' is loaded prior to 'kotlin-emotion'.");
    }
    if (typeof this['@emotion/styled'] === 'undefined') {
      throw new Error("Error loading module 'kotlin-emotion'. Its dependency '@emotion/styled' was not found. Please, check whether '@emotion/styled' is loaded prior to 'kotlin-emotion'.");
    }
    root['kotlin-emotion'] = factory(typeof this['kotlin-emotion'] === 'undefined' ? {} : this['kotlin-emotion'], kotlin, this['kotlin-csstype'], this['kotlin-extensions'], this['@emotion/css'], this['@emotion/styled']);
  }
}(this, function (_, Kotlin, $module$kotlin_csstype, $module$kotlin_extensions, $module$_emotion_css, $module$_emotion_styled) {
  'use strict';
  var $$importsForInline$$ = _.$$importsForInline$$ || (_.$$importsForInline$$ = {});
  var Kind_CLASS = Kotlin.Kind.CLASS;
  var defineInlineFunction = Kotlin.defineInlineFunction;
  var wrapFunction = Kotlin.wrapFunction;
  var FROM_PERCENTAGE;
  var TO_PERCENTAGE;
  var index;
  $$importsForInline$$['@emotion/css'] = $module$_emotion_css;
  FROM_PERCENTAGE = (0).toString() + '%';
  TO_PERCENTAGE = (100).toString() + '%';
  index = 0;
  return _;
}));

//# sourceMappingURL=kotlin-emotion.js.map

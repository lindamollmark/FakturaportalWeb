(function () {
  'use strict';

  angular
    .module('springBootClientApp.services', ['springBootClientApp.services.rest', 'springBootClientApp.services.invoice','springBootClientApp.services.client', 'springBootClientApp.services.auth', 'springBootClientApp.services.user' ]);
})();


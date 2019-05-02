var App = function () {

    /**
     * 私有方法
     */
    var handlerCheckbox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass   : 'iradio_minimal-blue'
        })
    };
    return {
      initCheckbox: function () {
          handlerCheckbox();

      }
    }
}();

$(document).ready(function () {
   App.initCheckbox();
});
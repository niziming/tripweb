var App = function () {
    // 主要的checkbox
    var _masterCheckbox;
    // 全部checkbox
    var _checkbox;
    var _pagetables;

    /**
     * 初始化ichack 激活
     * 私有方法
     */
    var handlerinitCheckbox = function () {
        //iCheck for checkbox and radio inputs
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        // 主要的checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 全部checkbox
        _checkbox = $('input[type="checkbox"].minimal');
    };
    /**
     * checkbox全选功能
     */
    var handlerCheckBoxAll = function () {
        // 绑定点击事件
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回true表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }
            // 选中
            else {
                _checkbox.iCheck("check");
            }
            // console.log(e.target.checked);
        });
    };




    // 暴露调用handerinitcheckbox
    return {
        init: function () {
            handlerinitCheckbox();
            handlerCheckBoxAll();
        },

        getCheckbox:function () {
            return _checkbox;
        }
    }
}();

$(document).ready(function () {
    App.init();
});

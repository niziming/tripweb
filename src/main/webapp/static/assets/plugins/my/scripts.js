(function ($) {
	
    "use strict";
    /*==============================
     Is mobile
     ==============================*/
    var isMobile = {
        Android: function () {
            return navigator.userAgent.match(/Android/i);
        },
        BlackBerry: function () {
            return navigator.userAgent.match(/BlackBerry/i);
        },
        iOS: function () {
            return navigator.userAgent.match(/iPhone|iPad|iPod/i);
        },
        Opera: function () {
            return navigator.userAgent.match(/Opera Mini/i);
        },
        Windows: function () {
            return navigator.userAgent.match(/IEMobile/i);
        },
        any: function () {
            return (isMobile.Android() || isMobile.BlackBerry() || isMobile.iOS() || isMobile.Opera() || isMobile.Windows());
        }
    }

    /* Datepicker */
    DatePicker();
    function DatePicker() {
        $(".awe-calendar:not(.from, .to)").datepicker({
            prevText: '<i class="lotus-icon-left-arrow"></i>',
            nextText: '<i class="lotus-icon-right-arrow"></i>',
            buttonImageOnly: false
        });

        /* Datepicker from - to */
        $(".awe-calendar.from").datepicker({
            prevText: '<i class="lotus-icon-left-arrow"></i>',
            nextText: '<i class="lotus-icon-right-arrow"></i>',
            buttonImageOnly: false,
            minDate: 0,
            dateFormat:"yy-mm-dd",
            onClose: function (selectedDate) {
                var newDate = new Date(selectedDate),
                    tomorrow = new Date(newDate.getTime() + 24 * 60 * 60 * 1000),
                    nextDate = tomorrow.getFullYear() + '-' + (tomorrow.getMonth() + 1) + '-' + tomorrow.getDate();
                $(".awe-calendar.to").datepicker("option", "minDate", nextDate).focus();
            }
        });
        $(".awe-calendar.to").datepicker({
            prevText: '<i class="lotus-icon-left-arrow"></i>',
            nextText: '<i class="lotus-icon-right-arrow"></i>',
            buttonImageOnly: false,
            minDate: 0,
            dateFormat:"yy-mm-dd",
            onClose: function (selectedDate) {
                //$(".awe-calendar.from").datepicker( "option", "maxDate", selectedDate );
            }
        });
    }

    /*Accordion*/
    Accordion();
    function Accordion() {
        $(".accordion").accordion({
            heightStyle: "content"
        });
    }

    /* Tabs */
    Tabs();
    function Tabs() {
        $('.tabs').tabs({
            show: {effect: "fadeIn", duration: 300},
            hide: {effect: "fadeOut", duration: 300}
        });
    }

    /* Select */
    aweSelect();
    function aweSelect() {
        $('.awe-select').each(function (index, el) {
            $(this).selectpicker();
        });

    }

    /* aweCalendar */
    aweCalendar();
    function aweCalendar() {
        $('.awe-calendar').each(function () {
            var aweselect = $(this);
            aweselect.wrap('<div class="awe-calendar-wrapper"></div>');
            aweselect.after('<i class="lotus-icon-calendar"></i>');
        });
    }

    /*Menu Sticky*/
    function MenuSticky() {
        if ($('#header_content').length) {
            var $this = $('#header_content'),
                size_point = $this.data().responsive,
                window_w = $(window).innerWidth(),
                window_scroll = $(window).scrollTop(),
                top_h = $('#header .header_top').innerHeight(),
                this_h = $this.innerHeight();

            if (size_point == undefined || size_point == '') {
                size_point = 1199;
            }

            if (window_scroll > top_h) {

                if (($this).hasClass('header-sticky') == false) {
                    $this.parent().addClass('header-sticky');

                    if (window_w <= size_point) {
                        $this.find('.header_menu').css('top', this_h + 'px');
                    }
                }

            } else {
                $this.parent().removeClass('header-sticky');

                if (window_w <= size_point) {
                    $this.find('.header_menu').css('top', (this_h + top_h) + 'px');
                }
            }
        }
    }

    /* Menu Resize */
    function MenuResize() {

        if ($('#header_content').length) {

            var $this = $('#header_content'),
                size_point = $this.data().responsive,
                window_scroll = $(window).scrollTop(),
                top_h = $('#header .header_top').innerHeight(),
                this_h = $this.innerHeight(),
                window_w = $(window).innerWidth();

            if (size_point == undefined || size_point == '') {
                size_point = 1199;
            }

            if (window_w <= size_point) {
                $this.addClass('header_mobile').removeClass('header_content');
            } else {
                $('.menu-bars').removeClass('active');
                $this.removeClass('header_mobile').addClass('header_content');
                $('#header_content .header_menu').css({
                    'top': ''
                }).removeClass('active').find('ul').css('display', '');
            }
        }
    }

    /* Menu Click */
    MenuBar();
    function MenuBar() {

        $('.menu-bars').on('click', function (event) {

            if ($('.header_menu').hasClass('active')) {
                $('.header_menu').removeClass('active');
                $(this).removeClass('active');
            } else {
                $('.header_menu').addClass('active');
                $(this).addClass('active');
            }

        });

        $('.menu li a').on('click', 'span', function (event) {
            event.preventDefault();

            var $this = $(this),
                $parent_li = $this.parent('a').parent('li'),
                $parent_ul = $parent_li.parent('ul');

            if ($parent_li.find('> ul').is(':hidden')) {
                $parent_ul.find('> li > ul').slideUp();
                $parent_li.find('> ul').slideDown();
            } else {
                $parent_li.find('> ul').slideUp();
            }

            return false;
        });
    }

    /* AwePopup */
    AwePopup(CallBackPopup);

    function CallBackPopup() {
        PopupCenter();
    }

    function AwePopup(callback) {

        $('.awe-ajax').on('click', function (event) {
            var $this = $(this),
                link_href = $this.attr('href');

            $('body').addClass('awe-overflow-h');
            $('#awe-popup-overlay, #awe-popup-wrap').addClass('in');

            getContentAjax(link_href, '#awe-popup-wrap .awe-popup-content', callback);

            return false;
        });

        $(document).on('click', '#awe-popup-overlay, #awe-popup-close, #awe-popup-wrap', function (event) {
            event.preventDefault();
            $('#awe-popup-wrap, #awe-popup-overlay').removeClass('in');
            $('body').removeClass('awe-overflow-h');
            $('#awe-popup-wrap .awe-popup-content').html('');
            return false;
        });

        $(document).on('click', '#awe-popup-wrap .awe-popup-content', function (event) {
            event.stopPropagation();
        });
    }

    function PopupCenter() {
        if ($('#awe-popup-wrap').hasClass('in')) {

            var $this = $('#awe-popup-wrap .awe-popup-content'),
                window_h = $(window).innerHeight(),
                height_e = $this.innerHeight(),
                height_part = (window_h - height_e) / 2;

            if (height_e < window_h && height_e > 0) {

                $this.parent().css({
                    'padding-top': height_part + 'px',
                    'padding-bottom': '0'
                });

            } else {

                $this.parent().css({
                    'padding-top': '10px',
                    'padding-bottom': '10px'
                });
            }
        }
    }

    function getContentAjax(url, id, callback, beforesend) {
        $.ajax({
            url: url,
            type: 'GET',
            dataType: 'html',
            beforeSend: function () {
                if (beforesend) {
                    beforesend();
                }
            }
        })
            .done(function (data) {

                $(id).html(data);

                // Apply callback
                if (callback) {
                    callback();
                }
            })
            .fail(function () {
                console.log("error");
            })
            .always(function () {
                console.log("complete");
            });
    }

    /*Banner Slide*/
    BannerSlider();
    function BannerSlider() {
        if ($('#banner-slider').length) {
            var offset_h = $('#header').innerHeight();
            $('#banner-slider').owlCarousel({
                autoPlay: 5000,
                navigation: true,
                singleItem: true,
                pagination: false,
                transitionStyle: 'fade',
                navigationText: ['<i class="lotus-icon-left-arrow"></i>', '<i class="lotus-icon-right-arrow"></i>'],
                beforeInit: function () {
                    var height = $('#banner-slider').data().height,
                        window_h = $(window).height(),
                        window_w = $(window).width();

                    $('.slider-item').each(function (index, el) {
                        var url = $(this).data().image;

                        $(this).css('background-image', 'url(' + url + ')');

                        if (height != '' && height != undefined) {

                            if (window_w > 767) {
                                $(this).css('height', height);
                            } else if (window_w <= 767) {
                                $(this).css('height', 500);
                            } else if (window_w <= 480) {
                                $(this).css('height', 400);
                            }

                        } else {
                            $(this).css('height', window_h - offset_h);
                        }

                    });

                },
                beforeUpdate: function () {
                    var height = $('#banner-slider').data().height,
                        window_w = $(window).width();

                    if (!(height != '' && height != undefined)) {
                        $('.slider-item').each(function (index, el) {
                            var window_h = $(window).height()
                            $(this).css('height', window_h - offset_h + 'px');
                        });
                    } else {
                        $('.slider-item').each(function (index, el) {
                            if (window_w > 767) {
                                $(this).css('height', height);
                            } else if (window_w <= 767) {
                                $(this).css('height', 500);
                            } else if (window_w <= 480) {
                                $(this).css('height', 400);
                            }
                        });
                    }
                }
            });
        }
    }

    /*Slider Home*/
    SliderRevolution();
    function SliderRevolution() {
        if ($('#slider-revolution').length) {
            jQuery('#slider-revolution').show().revolution({
                dottedOverlay: "none",
                delay: 7000,
                startwidth: 1060,
                startheight: 700,
                hideThumbs: 200,

                thumbWidth: 100,
                thumbHeight: 50,
                thumbAmount: 5,

                navigationType: "both",
                navigationArrows: "yes",
                navigationStyle: "round",

                touchenabled: "on",
                onHoverStop: "off",

                swipe_velocity: 0.7,
                swipe_min_touches: 1,
                swipe_max_touches: 1,
                drag_block_vertical: false,

                parallax: "mouse",
                parallaxBgFreeze: "on",
                parallaxLevels: [7, 4, 3, 2, 5, 4, 3, 2, 1, 0],

                keyboardNavigation: "off",

                navigationHAlign: "center",
                navigationVAlign: "bottom",
                navigationHOffset: 0,
                navigationVOffset: 20,

                soloArrowLeftHalign: "left",
                soloArrowLeftValign: "center",
                soloArrowLeftHOffset: 20,
                soloArrowLeftVOffset: 0,

                soloArrowRightHalign: "right",
                soloArrowRightValign: "center",
                soloArrowRightHOffset: 20,
                soloArrowRightVOffset: 0,

                shadow: 0,
                fullWidth: "on",
                fullScreen: "on",

                spinner: "spinner4",

                stopLoop: "off",
                stopAfterLoops: -1,
                stopAtSlide: -1,

                shuffle: "off",

                autoHeight: "off",
                forceFullWidth: "off",


                hideThumbsOnMobile: "off",
                hideNavDelayOnMobile: 1500,
                hideBulletsOnMobile: "off",
                hideArrowsOnMobile: "off",
                hideThumbsUnderResolution: 0,

                hideSliderAtLimit: 0,
                hideCaptionAtLimit: 0,
                hideAllCaptionAtLilmit: 0,
                startWithSlide: 0,
                fullScreenOffsetContainer: "#header"
            });
        }
    }

    /* Gallery Isotope */
    function GalleryIsotope() {
        if ($('.gallery').length) {
            $('.gallery').each(function (index, el) {
                var $this = $(this),
                    $isotope = $this.find('.gallery-isotope'),
                    $filter = $this.find('.gallery-cat');

                if ($isotope.length) {
                    var isotope_run = function (filter) {
                        $isotope.isotope({
                            itemSelector: '.item-isotope',
                            filter: filter,
                            percentPosition: true,
                            masonry: {columnWidth: '.item-size'},
                            transitionDuration: '0.8s',
                            hiddenStyle: {opacity: 0},
                            visibleStyle: {opacity: 1}
                        });
                    }

                    $filter.on('click', 'a', function (event) {
                        event.preventDefault();
                        $(this).parents('ul').find('.active').removeClass('active');
                        $(this).parent('li').addClass('active');
                        isotope_run($(this).attr('data-filter'));
                    });

                    isotope_run('*');
                }
            });
        }
    }

    /* Guest Book Masonry */
    function GuestBookMasonry() {
        if ($('.guest-book_mansory').length) {
            $('.guest-book_mansory').each(function (index, el) {
                $(this).isotope({
                    itemSelector: '.item-masonry'
                });
            });
        }
    }

    /* Modal*/
    $(".btn-play").click(function (event) {
        var target = $(this).attr('href'),
            url = $(target).data('video');

        var has_query_string = url.split('?', url);
        if(typeof has_query_string[1] == 'string'){
            url += '&' +$(target).data('query-string');
        }else{
            url += '?' + $(target).data('query-string');
        }
        $(target).find('iframe').attr('src', url);

        $(target).addClass('opened');
        $(target).click(function () {
            $(this).removeClass('opened').attr('src', '');
        });

        event.preventDefault();
    });

    /* Owl Single */
    function OwlSingle() {
        if ($('.owl-single').length) {
            $('.owl-single').each(function (index, el) {
                var $this = $(this);
                var options = {
                    autoPlay: false,
                    autoplayHoverPause: true,
                    singleItem: true,
                    smartSpeed: 1000,
                    navigation: true,
                    navigationText: ['<i class="lotus-icon-left-arrow"></i>', '<i class="lotus-icon-right-arrow"></i>']
                };
                var single_item = $this.data('single_item');

                if (typeof single_item == 'boolean' && single_item == false) {
                    options['singleItem'] = false;
                    var mobile = parseInt($this.data("mobile")),
                        tablet = parseInt($this.data("tablet")),
                        small_desktop = parseInt($this.data("small_desktop")),
                        desktop = parseInt($this.data("desktop")),
                        nav = ($this.data("nav")) ? true : false,
                        pagination = ($this.data("pagination")) ? true : false;
                    options['items'] = desktop;
                    options['itemsDesktop'] = [1200, desktop];
                    options['itemsDesktopSmall'] = [992, small_desktop];
                    options['itemsTablet'] = [767, tablet];
                    options['itemsMobile'] = [600, mobile];
                    options['navigation'] = nav;
                    options['pagination'] = pagination;
                }
                $this.owlCarousel(options);
            });
        }
    }

    var timeout_slider;
    $(window).resize(function () {
        clearTimeout(timeout_slider);
        timeout_slider = setTimeout(function () {
            OwlSingle();
        }, 500);
    }).resize();


    /* Coming Soon */
    CountDown();
    function CountDown() {
        if ($('#countdown').length) {

            var nextYear = new Date(new Date().getFullYear() + 1, 1 - 1, 26);
            $('#countdown').countdown(nextYear, function (event) {
                var $this = $(this).html(event.strftime(''
                    + '<div class="item"><span class="count">%D</span><span>Days</span></div>'
                    + '<div class="item"><span class="count">%H</span><span>Hours</span></div>'
                    + '<div class="item"><span class="count">%M</span><span>Minutes</span></div>'
                    + '<div class="item"><span class="count">%S</span><span>Seconds</span></div>'));
            });
        }
    }

    CountDate();
    /*==========  Count Date ==========*/
    function CountDate() {
        if ($('.count-date').length) {
            $('.count-date').each(function (index, el) {
                var $this = $(this),
                    end_date = $this.attr('data-end');

                if ($this.attr('data-end') !== '' && typeof $this.attr('data-end') !== 'undefined') {

                    $this.countdown(end_date, function (event) {
                        $(this).html(
                            event.strftime('<span> %D <span>Days</span></span> <span> %H <span>HOURS</span></span> <span> %M <span>MINUTES</span></span> <span> %S <span>SECONDS</span></span>')
                        );
                    });

                }

            });
        }
    }

    /* Popup Gallery */
    GalleryPopup();
    function GalleryPopup() {

        if ($('.gallery_item').length) {

            $('.gallery_item').each(function (index, el) {
                $(this).magnificPopup({
                    delegate: 'a', // the selector for gallery item
                    type: 'image',
                    mainClass: 'mfp-with-zoom',
                    zoom: {
                        enabled: true,
                        duration: 300,
                        easing: 'ease-in-out',
                    },
                    gallery: {
                        enabled: true,
                        arrowMarkup: '<button title="%title%" type="button" class="mfp-prevent-%dir% lotus-icon-%dir%-arrow"></button>',
                        tPrev: '',
                        tNext: ''
                    }
                });
            });
        }
    }

    /*Gallery Room Detail*/
    GalleryRoomDetail();
    function GalleryRoomDetail() {

        if ($('.room-detail_img').length) {

            $(".room-detail_img").owlCarousel({
                navigation: true,
                pagination: false,
                navigationText: ["<i class='fa fa-chevron-left'></i>", "<i class='fa fa-chevron-right'></i>"],
                singleItem: true,
                mouseDrag: false,
                transitionStyle: 'fade'
            });
        }

        if ($('.room-detail_thumbs').length) {

            $(".room-detail_thumbs").owlCarousel({
                items: 7,
                pagination: false,
                navigation: false,
                mouseDrag: false,
                navigationText: ["<i class='fa fa-chevron-left'></i>", "<i class='fa fa-chevron-right'></i>"],
                itemsCustom: [[0, 3], [320, 4], [480, 5], [768, 6], [992, 7], [1200, 7]]
            });

            if ($(".room-detail_img").data("owlCarousel") !== undefined && $(".room-detail_thumbs").data("owlCarousel") !== undefined) {
                $('.room-detail_thumbs').on('click', '.owl-item', function (event) {

                    var $this = $(this),
                        index = $this.index();
                    $('.room-detail_thumbs').find('.active').removeClass('active');
                    $this.addClass('active');
                    $(".room-detail_img").data("owlCarousel").goTo(index);

                    return false;
                });
            }
        }
    }

    /* ACCOMMODATIONS SLIDE */
    Accommodations1();
    function Accommodations1() {
        if ($('.accomd-modations-slide_1').length) {

            $(".accomd-modations-slide_1").owlCarousel({
                pagination: true,
                navigation: false,
                itemsCustom: [[0, 1], [480, 2], [992, 3], [1200, 3]]
            });

        }
    }

    /* SET BACKGROUND ROOM ITEM */
    BackgroundRoomItem();
    function BackgroundRoomItem() {
        $('.room_item-6, .room_item-5').each(function (index, el) {
            var $this = $(this),
                link_src = $this.data().background;

            if (link_src != undefined && link_src != '') {
                $this.css('background-image', 'url(' + link_src + ')');
            }
        });
    }

    /* Parallax */
    function ParallaxScroll() {
        if (isMobile.iOS()) {
            $('.awe-parallax, .awe-static').addClass('fix-background-ios');
        } else {
            $('.awe-parallax').each(function (index, el) {
                $(this).parallax("50%", 0.2);
            });
        }
    }

    /*STATISTICS Count Number*/
    StatisticsCount();
    function StatisticsCount() {
        if ($('.statistics_item .count').length) {

            $('.statistics_item').appear(function () {

                var count_element = $('.count', this).html();
                $(".count", this).countTo({
                    from: 0,
                    to: count_element,
                    speed: 2000,
                    refreshInterval: 50,
                });
            });
        }
    }

    /*View Password*/
    ViewPassword();
    function ViewPassword() {
        $('.view-pass').mousedown(function (event) {
            $(this).prev('input[type="password"]').attr('type', 'text');
        });
        $('.view-pass').mouseup(function (event) {
            $(this).prev('input[type="text"]').attr('type', 'password');
        });
    }

  

    $(document).ready(function () {
        $(window).load(function () {
            $('#preloader').delay(1000).fadeOut('400', function () {
                $(this).fadeOut()
            });
            $('body').append('<div class="awe-popup-overlay" id="awe-popup-overlay"></div><div class="awe-popup-wrap" id="awe-popup-wrap"><div class="awe-popup-content"></div><span class="awe-popup-close" id="awe-popup-close"></div>');
            GalleryIsotope();
            GuestBookMasonry();
        });

        $(window).scroll(function (event) {
            MenuSticky();
        });

        $(window).resize(function (event) {
            ParallaxScroll();
            PopupCenter();
            MenuResize();
            MenuSticky();
        }).trigger('resize');

    });

})(jQuery);

// function for ajax 
function sendBooking() {
    var $ = jQuery;
    $('#ajax-form-search-send').validate({
        rules: {
            name: {
                required: true,
                minlength: 2
            },
            surname: {
                required: false
            },
            email: {
                required: true,
                email: true
            },
            phone: {
                required: true,
                minlength: 9
            }
        },
        messages: {
            name: {
                required: "Please enter your name.",
                minlength: $.format("At least {0} characters required.")
            },
            email: {
                required: "Please enter your email.",
                email: "Please enter a valid email."
            },
            phone: {
                required: "Please enter your phone.",
                minlength: $.format("At least {0} characters required.")
            }
        },

        submitHandler: function (form) {
            $(form).ajaxSubmit({
                success: function (responseText, statusText, xhr, $form) {
                    $(form).parent().append(responseText);
                    $(form).remove();
                }
            });
            return false;
        }
    });

    $('#ajax-form-search-send').submit();
    return false;
}

/*设置默认预订日期为明天到后天*/
var date = new Date();
date.setDate(date.getDate()+1);
$(".from").datepicker('setDate',date);
date.setDate(date.getDate()+1);
$(".to").datepicker('setDate',date);
/*  ---------------------------------------------------
    Template Name: Ogani
    Description:  Ogani eCommerce  HTML Template
    Author: Colorlib
    Author URI: https://colorlib.com
    Version: 1.0
    Created: Colorlib
---------------------------------------------------------  */

'use strict';

(function ($) {

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

        /*------------------
            Gallery filter
        --------------------*/
        $('.featured__controls li').on('click', function () {
            $('.featured__controls li').removeClass('active');
            $(this).addClass('active');
        });
        if ($('.featured__filter').length > 0) {
            var containerEl = document.querySelector('.featured__filter');
            var mixer = mixitup(containerEl);
        }
    });

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
        Categories Slider
    ------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            0: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });


    $('.hero__categories__all').on('click', function(){
        $('.hero__categories ul').slideToggle(400);
    });

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 3,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 2,
            },

            992: {
                items: 3,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------
		Price Range Slider
	------------------------ */
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 1));
    maxamount.val('$' + rangeSlider.slider("values", 1));

    /*--------------------------
        Select
    ----------------------------*/
    $("select").niceSelect();

    /*------------------
		Single Product
	--------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
	--------------------- */

    var finalTotal = 0;

    function updateTotal($row) {
        var quantity = parseFloat($row.find('.pro-qty input').val());

        var price = parseFloat($row.find('.shoping__cart__price span').text());
        var total = quantity * price;
        finalTotal += total;

        $row.find('.shoping__cart__total').text('$' + total.toFixed(2));
        updateFinalTotal(); // Gọi hàm cập nhật tổng giá trị cuối cùng
    }

    function updateDecTotal($row) {
        var quantity = parseFloat($row.find('.pro-qty input').val());

        var price = parseFloat($row.find('.shoping__cart__price span').text());
        var total = quantity * price;
        finalTotal -= total;

        $row.find('.shoping__cart__total').text('$' + total.toFixed(2));
        updateFinalTotal(); // Gọi hàm cập nhật tổng giá trị cuối cùng
    }

    function updateFinalTotal() {
        var total = 0;
        $('.shoping__cart__total').each(function () {
            var value = parseFloat($(this).text().replace('$', ''));
            if (!isNaN(value)) {
                total += value;
            }
        });
        $('#finalTotal span').text('$' + total.toFixed(2));
    }


    $('.cart-item').each(function () {
        var $row = $(this);
        var quantity = parseFloat($row.find('.pro-qty input').val());

        var price = parseFloat($row.find('.shoping__cart__price span').text());
        var total = quantity * price;
        finalTotal += total;

        $row.find('.shoping__cart__total').text('$' + total.toFixed(2));
        $row.find('.shoping__cart__total-per-item').text('$' + price.toFixed(2)); // Thêm dòng này để cập nhật giá trị của từng total
    });

    updateFinalTotal(); // Gọi hàm cập nhật tổng giá trị cuối cùng

    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');

// Lắng nghe sự kiện khi giá trị thay đổi
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var $row = $button.closest('.cart-item');

        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
            $button.parent().find('input').val(newVal);
            updateTotal($row);
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
                $button.parent().find('input').val(newVal);
                updateDecTotal($row);
            } else {
                newVal = 1;
            }
        }
    });
    proQty.on('change', 'input', function () {
        var $input = $(this);
        if ($input.val() === '') {
            // alert('number');
            $input.val($input.data('old-value'));
        }
        var $row = $input.closest('.cart-item');

        var oldValue = $input.data('old-value');
        var newValue = parseFloat($input.val());
        if (isNaN(newValue)) {
            newValue = 1;
        }
        if (isNaN(oldValue)) {
            newValue = 1;
        }

        var delta = newValue - oldValue;
        var quantity = parseFloat($row.find('.pro-qty input').val());
        var price = parseFloat($row.find('.shoping__cart__price span').text());
        var total = quantity * price;
        var deltaTotal = delta * price;
        finalTotal += deltaTotal;

        $row.find('.shoping__cart__total').text('$' + total.toFixed(2));
        $row.find('.shoping__cart__total-per-item').text('$' + price.toFixed(2)); // Thêm dòng này để cập nhật giá trị của từng total
        updateFinalTotal(); // Gọi hàm cập nhật tổng giá trị cuối cùng

        $input.data('old-value', newValue);
    });
    $('.pro-qty input').on('input', function() {
        $(this).trigger('change');
    });




})(jQuery);
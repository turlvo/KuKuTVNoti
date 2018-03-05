/**
 * Created by turlvo on 2017-05-28.
 */
var express = require('express');
var router = express.Router();

// test route to make sure everything is working (accessed at GET /lgtv/:ip/noti/:message)
router.post('/:ip/noti/:message', function(req, res) {
    console.log('request : ' + req.url)
    res.json({ message: 'hooray! welcome to our api!' });
    var lgtv = require("lgtv2")({
        url: 'ws://' + req.params.ip + ':3000'
    });

    lgtv.on('connect', function () {
        console.log('connected');
        lgtv.request('ssap://system.notifications/createToast', {message: req.params.message});
        lgtv.disconnect();


    });
});

// test route to make sure everything is working (accessed at GET http://localhost:8080/api)
router.get('/:ip/service-list', function(req, res) {
    console.log('ip :' + req.params.ip)
    var lgtv = require("lgtv2")({
        url: 'ws://' + req.params.ip + ':3000'
    });

    lgtv.on('connect', function () {
        lgtv.request('ssap://audio/getStatus', function (err, response) {
            console.log('response', response);
            response.send("noti");
        });
    });
});
// more routes for our API will happen here

module.exports = router;

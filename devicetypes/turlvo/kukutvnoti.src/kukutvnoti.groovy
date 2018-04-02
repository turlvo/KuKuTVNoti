/**
*  KuKuTVNoti
*
*  Copyright 2017 KuKu
*
*  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License. You may obtain a copy of the License at:
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
*  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
*  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
*  for the specific language governing permissions and limitations under the License.
*
*/
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

metadata {
    definition (name: "KuKuTVNoti", namespace: "turlvo", author: "KuKu") {
        capability "Notification"

        command "sendNoti", ["string"]
        command "noti1"
        command "noti2"
        command "noti3"
        command "noti4"
        command "noti5"
        command "noti6"
        command "noti7"
        command "noti8"
    }

    preferences {
        input name: "serverIp", type: "string", title: "KuKuTVNoti server IP address:", description: "Example) 192.168.1.137", required: true, displayDuringSetup: true
        input name: "serverPort", type: "string", title: "KuKuTVNoti server Port:", description: "Example) 8383", required: true, displayDuringSetup: true
        //input name: "serverMac", type: "string", title: "KuKuTVNoti server MAC:", description: "Example) 12:34:56:78:90", required: true, displayDuringSetup: true
        input name: "tvIp", type: "string", title: "TV IP address:", description: "Example) 192.168.1.111", required: true, displayDuringSetup: true
        
        input name: "noti1msg", type: "string", title: "Noti1 message:", description: "",displayDuringSetup: true
        input name: "noti2msg", type: "string", title: "Noti2 message:", description: "",displayDuringSetup: true
        input name: "noti3msg", type: "string", title: "Noti3 message:", description: "",displayDuringSetup: true
        input name: "noti4msg", type: "string", title: "Noti4 message:", description: "",displayDuringSetup: true
        input name: "noti5msg", type: "string", title: "Noti5 message:", description: "",displayDuringSetup: true
        input name: "noti6msg", type: "string", title: "Noti6 message:", description: "",displayDuringSetup: true
        input name: "noti7msg", type: "string", title: "Noti7 message:", description: "",displayDuringSetup: true
        input name: "noti8msg", type: "string", title: "Noti8 message:", description: "",displayDuringSetup: true
        
    }

    // UI tile definitions
    tiles(scale: 2) {
        standardTile("status", "device.status", width: 1, height: 1, canChangeIcon: false, canChangeBackground: false) {
			state("active", label:'Active', icon:"st.custom.sonos.unmuted", backgroundColor:"#53a7c0")
			state("inactive", label:'Disconnect', icon:"st.custom.sonos.unmuted", backgroundColor:"#ffffff")
		}
        valueTile("noti1", "device.noti1", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti1", label: '${currentValue}', action: "noti1"
        }
        valueTile("noti2", "device.noti2", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti2", label: '${currentValue}', action: "noti2"
        }
        valueTile("noti3", "device.noti3", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti3", label: '${currentValue}', action: "noti3"
        }
        valueTile("noti4", "device.noti4", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti4", label: '${currentValue}', action: "noti4"
        }
        valueTile("noti5", "device.noti5", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti5", label: '${currentValue}', action: "noti5"
        }
        valueTile("noti6", "device.noti6", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti6", label: '${currentValue}', action: "noti6"
        }
        valueTile("noti7", "device.noti7", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti7", label: '${currentValue}', action: "noti7"
        }
        valueTile("noti8", "device.noti8", width: 3, height: 2, decoration: "flat", canChangeIcon: false, canChangeBackground: false) {
            state "noti8", label: '${currentValue}', action: "noti8"
        }
        

        main "status"
        details(["noti1", "noti2", "noti3", "noti4", "noti5", "noti6", "noti7", "noti8"])
    }
}

def installed() {
	log.debug "installed()"
	initialize()
}

def initialize() {
    log.debug "initialize()"
}

def updated() {
    log.debug "updated>>"
    sendEvent(name: "noti1", value: settings.noti1msg)
    sendEvent(name: "noti2", value: settings.noti2msg)
    sendEvent(name: "noti3", value: settings.noti3msg)
    sendEvent(name: "noti4", value: settings.noti4msg)
    sendEvent(name: "noti5", value: settings.noti5msg)
    sendEvent(name: "noti6", value: settings.noti6msg)
    sendEvent(name: "noti7", value: settings.noti7msg)
    sendEvent(name: "noti8", value: settings.noti8msg)
}

def noti1() {
    def msg = device.currentState("noti1")?.value
    log.debug "noti1>> " + msg
    sendNoti(msg)
}

def noti2() {
    def msg = device.currentState("noti2")?.value
    log.debug "noti2>> " + msg
    sendNoti(msg)
}

def noti3() {
    def msg = device.currentState("noti3")?.value
    log.debug "noti3>> " + msg
    sendNoti(msg)
}

def noti4() {
    def msg = device.currentState("noti4")?.value
    log.debug "noti4>> " + msg
    sendNoti(msg)
}

def noti5() {
    def msg = device.currentState("noti5")?.value
    log.debug "noti5>> " + msg
    sendNoti(msg)
}

def noti6() {
    def msg = device.currentState("noti6")?.value
    log.debug "noti6>> " + msg
    sendNoti(msg)
}

def noti7() {
    def msg = device.currentState("noti7")?.value
    log.debug "noti7>> " + msg
    sendNoti(msg)
}

def noti8() {
    def msg = device.currentState("noti8")?.value
    log.debug "noti8>> " + msg
    sendNoti(msg)
}

// Store the MAC address as the device ID so that it can talk to SmartThings
def setNetworkAddress() {
    // Setting Network Device Id
    def hex = "$settings.serverMac".toUpperCase().replaceAll(':', '')
    if (device.deviceNetworkId != "$hex") {
        device.deviceNetworkId = "$hex"
        log.debug "Device Network Id set to ${device.deviceNetworkId}"
    }
}

// Parse events from the Bridge
def parse(String description) {

}

// Send message to the Bridge
def sendNoti(msg) {
    if (device.hub == null)
    {
        log.error "Hub is null, must set the hub in the device settings so we can get local hub IP and port"
        return
    }
    
    log.debug "Sending '${msg}' to device"
    setNetworkAddress()

    def path = "/lgtv/" + settings.tvIp + "/noti"
    log.debug "path is: $path"
    
    //def callback = device.hub.getDataValue("localIP") + ":" + device.hub.getDataValue("localSrvPortTCP")

    def headers = [:]
    headers.put("HOST", "$serverIp:$serverPort")
    headers.put("Content-Type", "application/json")
    log.debug "headers is: $headers"
    
    def body = [:]
    body.put("callback", device.hub.getDataValue("localIP") + ":" + device.hub.getDataValue("localSrvPortTCP"))
    body.put("msg", msg)

    def hubAction = new physicalgraph.device.HubAction(
        method: "POST",
        path: path,
        headers: headers,
        body: body
    )
    hubAction
    
}
/*
private sendNoti(msg){
    log.debug "sendNoti>> msg : " + msg

    def host = "192.168.1.137"
    def port = "8383"
    def levelCommand = 0x00
    def hosthex = convertIPtoHex(host)
    def porthex = convertPortToHex(port)
    log.debug "The device id before update is: $device.deviceNetworkId"
    device.deviceNetworkId = "$hosthex:$porthex"     
    log.debug "The device id configured is: $device.deviceNetworkId"

    def path = "/lgtv/192.168.1.129/noti/test"
    log.debug "path is: $path"

    def headers = [:] 
    headers.put("HOST", "$host:$port")

    try {
        def hubAction = new physicalgraph.device.HubAction(
            method: "GET",
            path: path,
            headers: headers
        )
        state.requestCounter=1
        return hubAction

    }
    catch (Exception e) {
        log.debug "Hit Exception $e on $hubAction"
    }
}
*/

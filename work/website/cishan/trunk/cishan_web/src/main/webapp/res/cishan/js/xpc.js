(function(e){e(function(){function o(e,t){this.name=t||"XPC_IFRAME",this.target=e}function u(n,r){this.targets={},this.name=n||"MAIN_DOC",this.listenFunc=[],t(this);var i=e({defaultMain:!0},r||{},!0);!s&&i.defaultMain&&this.addTarget("MAIN_DOC"),this.initListen()}var e=function(e,t,n){n=n||function(t,n,r){return e[r]||r in e?t:n},n===!0&&(n=function(e,t){return t});for(var r in t)e[r]=n(e[r],t[r],r,e,t),e[r]===undefined&&delete e[r];return e},t=function(t){var n={};return e(t,{on:function(e,t){n[e]=n[e]||[],n[e].push(t)},fire:function(r,i){i=i||{},e(i,{type:r,target:t,preventDefault:function(){i.returnValue=!1}});var s=n[r]||[];for(var o=0;o<s.length;o++)s[o](i);return i.returnValue!==!1}}),t},n=function(e,t,n){e.addEventListener?e.addEventListener(t,n,!1):e.attachEvent&&(e["e"+t+n]=n,e.attachEvent("on"+t,function(){e["e"+t+n].call(e,window.event)}))},r="[PROJECT_NAME]",i="postMessage"in window,s=parent==window;return i?o.prototype.send=function(e){this.target.postMessage(r+e,"*")}:o.prototype.send=function(e){var t=window.navigator[r+this.name];if(typeof t!="function")throw new Error("target callback function is not defined");t(r+e,window)},u.prototype.addTarget=function(e){if({}.toString.call(e)==="[object Array]")for(var t=0,n=e.length;t<n;t++)this.addTarget(e[t]);else{var r=new o(s?window.frames[e]:parent,e);this.targets[e]=r}},u.prototype.initListen=function(){var e=this,t=function(t){typeof t=="object"&&t.data&&(t=t.data);if(typeof t!="string"||t.indexOf(r)!=0)return;t=t.slice(r.length),e.fire("message",{msg:t,ts:(+(new Date)).toString(36)})};i?n(window,"message",t):window.navigator[r+this.name]=t},u.prototype.send=function(e){var t=this.targets,n;for(n in t)t.hasOwnProperty(n)&&t[n].send(e)},u})})(typeof define=="function"&&define.amd?define:function(e,t,n){typeof e=="function"?n=e:typeof t=="function"&&(n=t),typeof module!="undefined"?module.exports=n(require):typeof window!="undefined"&&(window.XPC=n())});
### 使用webSocket

1. 引入依赖

   `crm-websocket-starter`
   
2. 启动后端WebSocket服务


3. 前端做登录请求,以便后续根据具体的用户绑定对应的WebSocketSession

   `http://192.168.5.35:8080/demo/login/2`
   
   
4. 前端先连接一次后端,即:做一次协议握手(后续保持连接)

   ```javascript
   // 浏览器打开http://192.168.5.35:8080/test.html
   websocket = new WebSocket("ws://192.168.5.35:8080/myHandler");
   ```
 
5. 前后端做消息交互,全双工交互,详细见代码

   ```javascript
   // 后端主动推送消息给对应的用户
   浏览器访问:http://192.168.5.35:8080/demo/sendMessage

   ```
const globalConstElem = document.querySelector('#globalConst');
const dmUserListContainerElem = document.querySelector('.dm_user_list_container');

function getDmUserList() {
    myFetch.get('/dm/list', myJson => {
        console.log(myJson);
        if(myJson.length > 0) {
            makeDmUserList(myJson);
        }
    });
}

function makeDmUserList(userList) {
    userList.forEach(function(item) {
        const div = makeDmUserItem(item);
        dmUserListContainerElem.append(div);
    })
}

getDmUserList();

function makeDmUserItem(item) {
    const div = document.createElement('div');
    div.className = 'pointer d-flex flex-row w-full'
    div.innerHTML = `
        <div class="w100">
            <img src="/pic/profile/${item.opponent.iuser}/${item.opponent.mainimg}" class="profile w30 h30" 
             onerror="this.onerror=null; this.src='/img/defaultProfileImg.png'">
        </div>
        <div class="flex-grow-1">
            <div>${item.opponent.nm}</div>
            <div>${item.lastmsg}</div>
        </div>
    `;
    div.addEventListener('click', function() {
        dmMsgContainerElem.innerHTML = null;
        connect(item.idm);
    })
    return div;
}

const globalIuser = globalConstElem.dataset.iuser;
const dmMsgContainerElem = document.querySelector('.dm_msg_container');
const msgInput = document.querySelector('#msg_input');
const dmMsgSendBtn = document.querySelector('#button-send');
dmMsgSendBtn.addEventListener('click', function() {
    if(globalIdm && msgInput.value) {
        sendMsg(msgInput.value);
        msgInput.value = '';
    }
});

const sock = new SockJS('/ws-dm');
const ws = Stomp.over(sock);
let globalIdm = 0;
ws.connect({}, function() {
    console.log('STOMP Connection !!');
});

function connect(idm) {
    ws.unsubscribe(); //이전 연결된 구독이 있으면 제거
    console.log(`idm : ${idm}`);
    globalIdm = idm;
    ws.subscribe(`/sub/room/${idm}`, onMessage);
}

function sendMsg(msg) {
    if(ws) {

        ws.send('/pub/msg', {}, JSON.stringify({ type: 'CHAT', idm:globalIdm, iuser:globalIuser, msg: msg}))
    }
}

function onMessage(msg) {
    console.log('onMessage');
    const data = JSON.parse(msg.body);
    console.log(data);

    //로그인 한 클라이언트와 타 클라이언트를 분류하기 위함
    const div = document.createElement('div');
    div.className = 'col-6';

    const inClassName = globalIuser == data.iuser ? 'alert-secondary' : 'alert-warning';
    div.innerHTML = `
        <div class='alert ${inClassName}'>
            <b>${data.msg}</b>
        </div>
    `;
    console.log('data.msg : ' + data.msg);
    console.log(div);
    dmMsgContainerElem.append(div);
    dmMsgContainerElem.scrollTop = dmMsgContainerElem.scrollHeight;
}




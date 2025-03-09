// Establish WebSocket connection
const socket = new SockJS('/ws');
const stompClient = Stomp.over(socket);

let senderEmail = document.getElementById("senderEmail").value;
let receiverEmail = document.getElementById("receiverEmail").value;

stompClient.connect({}, function () {
    console.log("Connected to WebSocket");

    // Subscribe to receive messages
    stompClient.subscribe(`/user/${senderEmail}/queue/messages`, function (message) {
        const receivedMessage = JSON.parse(message.body);
        displayMessage(receivedMessage);
    });
});

// Function to send a message
function sendMessage() {
    const messageContent = document.getElementById("messageInput").value;

    if (messageContent.trim() !== "") {
        const message = {
            senderEmail: senderEmail,
            receiverEmail: receiverEmail,
            content: messageContent
        };

        // Send message via WebSocket
        stompClient.send("/app/chat.sendMessage", {}, JSON.stringify(message));

        // Display message instantly
        displayMessage(message);
        document.getElementById("messageInput").value = "";
    }
}

// Function to display a message in chat
function displayMessage(message) {
    const chatBox = document.getElementById("chatBox");
    const messageElement = document.createElement("div");

    messageElement.classList.add("message");
    messageElement.innerHTML = `<strong>${message.senderEmail}:</strong> ${message.content}`;
    chatBox.appendChild(messageElement);
}

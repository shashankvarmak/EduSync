document.addEventListener("DOMContentLoaded", function () {
    const senderEmail = document.getElementById("loggedInEmail").value;
    let receiverEmail = null;

    const socket = new SockJS('/ws');
    const stompClient = Stomp.over(socket);

    stompClient.connect({}, function () {
        console.log("✅ Connected to WebSocket");

        // Subscribe to receive real-time messages
        stompClient.subscribe(`/topic/messages`, function (message) {
            const receivedMessage = JSON.parse(message.body);
            console.log("📩 New Message Received:", receivedMessage);

            // Only update the chat if the message belongs to the current chat
            if (receivedMessage.senderEmail === receiverEmail || receivedMessage.receiverEmail === receiverEmail) {
                updateChat(receivedMessage);
            }
        });
    });

    function updateChat(message) {
        console.log("📌 Updating Chat UI with:", message);
        const messageContainer = document.getElementById("messageContainer");

        const messageDiv = document.createElement("div");
        messageDiv.classList.add("message", message.senderEmail === senderEmail ? "sent" : "received");
        messageDiv.innerHTML = `<strong>${message.senderEmail}:</strong> ${message.content}`;

        messageContainer.appendChild(messageDiv);
        messageContainer.scrollTop = messageContainer.scrollHeight;
    }

    // Function to send a message
    document.getElementById("sendMessageBtn").addEventListener("click", function () {
        const messageInput = document.getElementById("messageInput");
        const messageText = messageInput.value.trim();

        if (messageText !== "" && receiverEmail !== null) {
            const message = {
                senderEmail: senderEmail,
                receiverEmail: receiverEmail,
                content: messageText
            };

            stompClient.send("/app/chat", {}, JSON.stringify(message));

            // Manually update chat UI instantly
            updateChat(message);

            // Clear input field
            messageInput.value = "";
        }
    });

    // Click event for selecting users in inbox
    document.querySelectorAll(".user-item").forEach(item => {
        item.addEventListener("click", function () {
            receiverEmail = this.getAttribute("data-email");
            document.getElementById("chatHeader").innerText = `Chat with ${receiverEmail}`;

            // Fetch previous chat messages
            fetch(`/messages/chat/${receiverEmail}`)
                .then(response => response.json())
                .then(messages => {
                    const messageContainer = document.getElementById("messageContainer");
                    messageContainer.innerHTML = ""; // Clear old messages

                    messages.forEach(msg => updateChat(msg));
                });
        });
    });
});

let stompClient = null;

function connect() {
  stompClient = Stomp.over(new SockJS("/websocket"));
  stompClient.connect(
    {},
    (frame) => {
      console.log("Connected: " + frame);
      stompClient.subscribe("/topic/message." + $("#uuid").val(), (response) => {
        updateDisplay(JSON.parse(response.body));
      });
    },
    (error) => {
      $("#noConnection").show();
    }
  );
}

const updateDisplay = (message) => {
  $("#message-head").html(message.head);
  $("#message-body").html(message.body);
  $("#customer").html(message.customer);
  $("#discount").html(message.totals.discount);
  $("#amount").html(message.totals.amount);
};

const processDocumentReady = () => {
  $("#noConnection").hide();
  connect();
};

$(document).ready(processDocumentReady);
(function () {
    const socket = io.connect('http://127.0.0.1:9000')
    let username = 'Anon'
    const clearForm = () => {
        $('input[name="message"]').val('')
    }
    socket.on('connect', () => {
        console.log('Hello from websocket connection')
    })

    socket.on('disconnect', () => {
        console.log('Disconnected')
    })

    socket.on('SEND_MESSAGE', (data) => {
        const { message, user } = data
        const tmpl = `
            <p>${user}: ${message}</p>
        `
        $('#messages').append(tmpl)
        clearForm()
    })

    socket.on('CHANGE_USER', (data) => {
        const  { user } = data
        username = user
    })

    $('#btn_send').on('click', function() {
        const message = {
            user: username,
            message: $('input[name="message"]').val()
        }        

        socket.emit('SEND_MESSAGE', message)
    })
    $('#btn_user').on('click', function() {
        const user = {
            user: $('input[name="user"]').val()
        }
        socket.emit('CHANGE_USER', user)
    })
})()
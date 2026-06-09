function testCall() {
    console.log('hello, world!')
}

function createPost() {

    const data  = getPostValues();

    fetch(`http://localhost:8080/posts`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    }).then(
        resp => resp.json()
    ).then(
        data => {
            console.log(data);

            const msg = data.message;

            alert(msg);

        }
    )
    .catch(
        err => {
            console.log(err);
        }
    )

}

export const Services = {
    get: async function(url, onSuccess, onFail, token) {
        console.log(localStorage.getItem("token"))
        await fetch(url,
            {
                method: "GET",
                headers: {"Authorization": localStorage.getItem("token")},
            }).then(response => {
                return response.json()
            })
            .then(data => {
                console.log(data)
                if (data.code === '200') {
                    onSuccess(data);
                } else {
                    localStorage.setItem("token", "")
                    onFail(data);
                }
                return data;
            }).catch(error => {
                alert(error.message);
            })
    },
    post: (url, body, onSuccess, onFail, token) => {
        fetch(url,
            {
                method: "POST",
                headers: {"Authorization": localStorage.getItem("token")},
                body: body
            }).then(response => response.json())
            .then(data => {
                if (data.code === '200') {
                    onSuccess(data);
                } else {
                    localStorage.setItem("token", "")
                    onFail(data);
                }
            }).catch(error => {
                alert(error.message);
            })
    }
}
export const Services = {
    get: async function(url, onSuccess, onFail, token) {
        await fetch(url,
            {
                method: "GET",
                headers: {"Authorization": token},
            }).then(response => {
                return response.json()
            })
            .then(data => {
                console.log(data)
                if (data.code === '200') {
                    onSuccess(data);
                } else {
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
                headers: {"Authorization": token || ""},
                body: body
            }).then(response => response.json())
            .then(data => {
                if (data.code === '200') {
                    onSuccess(data);
                } else {
                    onFail(data);
                }
            }).catch(error => {
                alert(error.message);
            })
    }
}
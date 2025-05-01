package main

import (
	"encoding/json"
	"github.com/gorilla/mux"
	"net/http"
)

type User struct {
	Name  string
	Email string
	Id    int
}

var data = []User{
	{"John", "john@gmail.com", 1},
	{"John2", "john2@gmail.com", 2},
	{"John3", "john3@gmail.com", 3},
}

func main() {
	router := mux.NewRouter()

	router.HandleFunc("/user", func(w http.ResponseWriter, r *http.Request) {
		response, err := json.Marshal(data)
		if err != nil {
			return
		}
		w.Write(response)
	}).Methods(http.MethodGet)

	router.HandleFunc("/user", func(w http.ResponseWriter, r *http.Request) {
		var reqInfo User
		json.NewDecoder(r.Body).Decode(&reqInfo)
		data = append(data, reqInfo)
	}).Methods(http.MethodPost)

	http.ListenAndServe(":8080", router)

}

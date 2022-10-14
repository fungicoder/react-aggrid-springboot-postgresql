import http from "../http-common";

class UserDataService {
    getAll() {
        return http.get("/users");
    }

    get(user_id) {
        return http.get(`/users/${user_id}`);
    }

    create(data) {
        return http.post("/users", data);
    }

    update(user_id, data) {
        return http.put(`/users/${user_id}`, data);
    }

    delete(user_id) {
        return http.delete(`/users/${user_id}`);
    }

    deleteAll() {
        return http.delete(`/users`);
    }

    findByName(fullName) {
        return http.get(`/users?fullName=${fullName}`);
    }
}

export default new UserDataService();
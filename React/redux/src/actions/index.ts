import * as React from 'react';
import { axiosInstance } from '../util/axiosConfig';
import { User } from '../components/LoginComponent/User';
import Axios from 'axios';

export const LoginTypes = {
    SUCCESS: "SUCCESS",
    FAIL: "FAIL",
};

export const login = () => async (dispatch: any) => {
    const response = await axiosInstance.get("");
    console.log("Dispatching to reducer");
    let payload = response.data;
    dispatch({
        type: LoginTypes.SUCCESS,
        payload: payload
    });
}

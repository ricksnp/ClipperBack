import { LoginTypes } from '../actions/index';

const initialState: any = {
    users: []
};


export const UserReducer = (state = initialState, action: any): any => {
    switch (action.type) {
        case LoginTypes.SUCCESS:
            return {
                ...state, ...action.payload
            };
        default:
            return state;
    }
}
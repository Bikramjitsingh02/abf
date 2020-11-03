package com.pragra.abfapi.constants;

public class EndpointPath {

    public static final String COURIERS = "/couriers";
    public static final String LIST_COURIERS = COURIERS;
    public static final String LIST_ALL_COURIERS = COURIERS + "/all";
    public static final String DETECT_COURIERS = COURIERS + "/detect";

    public static final String TRACKING = "/trackings";
    public static final String CREATE_TRACKING = TRACKING;
    public static final String DELETE_TRACKING = TRACKING;
    public static final String GET_TRACKING = TRACKING;
    public static final String GET_TRACKINGS = TRACKING;
    public static final String UPDATE_TRACKING = TRACKING;
    public static final String UPDATE_RETRACK = TRACKING;
    public static final String UPDATE_RETRACK_ACTION = "retrack";
    public static final String MARK_AS_COMPLETED = TRACKING;
    public static final String MARK_AS_COMPLETED_ACTION = "mark-as-completed";

    public static final String GET_LAST_CHECKPOINT = "/last_checkpoint";

    public static final String NOTIFICATION = "/notifications";
    public static final String GET_NOTIFICATION = NOTIFICATION;
    public static final String ADD_NOTIFICATION = NOTIFICATION;
    public static final String ADD_NOTIFICATION_ACTION = "add";
    public static final String REMOVE_NOTIFICATION = NOTIFICATION;
    public static final String REMOVE_NOTIFICATION_ACTION = "remove";

}

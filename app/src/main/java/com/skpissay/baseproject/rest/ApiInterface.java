package com.skpissay.baseproject.rest;


import com.skpissay.baseproject.models.User;
import com.skpissay.baseproject.rest.response.BasicResponse;

import java.util.List;
import java.util.Map;

import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by chethan on 5/12/16.
 */

public interface ApiInterface {

    @GET("api/places")
    Observable<Response<BasicResponse>> getPlaces();

    @GET("users/{username}")
    Observable<Response<List<User>>> getUsers(@Path("username") String username, @Query("access_token") String authToken);

    @GET("users/{username}/followers")
    Observable<Response<List<User>>> getUsersFollowers(@Path("username") String username);

    /*@GET("/api/Payments/retailers/{id}/invoices")
    Observable<Response<PaymentsBasicResponse>> fetchInvoicesByStatus(@Path("id") int retailerId, @Query("search") String search, @Query("size") int size);

    @GET("deviceMetrix")
    Observable<Response<BasicResponse>> getDeviceMetrix();

    @GET("api/Retailers/{id}/fetchShortbook")
    Observable<Response<ShortbookResponse>> fetchShortbook(@Path("id") int retailerId);

    @DELETE("api/Retailers/{id}/Shortbooks/{shortbookId}/clearShortbook")
    Observable<Response<ShortbookResponse>> clearShortbook(@Path("id") int retailerId, @Path("shortbookId") int shortbookId);

    @GET("api/ProductsSearch/search/{searchTerm}")
    Observable<Response<List<Product>>> searchProducts(@Path("searchTerm") String searchTerm);

    @PUT("api/Retailers/{id}/Shortbooks/{shortbookId}/updateShortbook")
    Observable<Response<ShortbookResponse>> updateToShortbook(@Path("id") int retailerId, @Path("shortbookId") int shortbookId, @Body ShortbookRequest request);


    @PUT("api/Retailers/{id}/Shortbooks/{shortbookId}/ShortbookItems/{shortbookItemId}/updateQuantity")
    Observable<Response<ShortbookResponse>>
    updateShortbookQuantity(@Path("id") int retailerId,
                            @Path("shortbookId") int shortbookId, @Path("shortbookItemId")
                                    int shortbookItemId,
                            @Body ShortbookRequest request);

    @GET("api/Retailers/{id}/fetchCart")
    Observable<Response<CartResponse>> fetchCart(@Path("id") int retailerId);

    @GET("api/Retailers/{id}/Products/{productId}/Quantity/{quantity}/fetchDistributorOffers")
    Observable<Response<List<DistributorResponse>>> fetchDistributors(@Path("id") int retailerId, @Path("productId") int productId, @Path("quantity") int quantity);

    @PUT("api/Retailers/{id}/Carts/{cartId}/updateCart")
    Observable<Response<CartResponse>> updateToCart(@Path("id") int retailerId, @Path("cartId") int cartId, @Body CartRequest request);

    @FormUrlEncoded
    @PUT("api/Retailers/{id}/Carts/{cartId}/CartItems/{cartItemId}/updateQuantity")
    Observable<Response<CartResponse>> updateQuantity(
            @Path("id") int retailerId,
            @Path("cartId") int cartId,
            @Path("cartItemId") int cartItemId,
            @Field("quantity") int quantity,
            @Field("cart") String cart);

    @PUT("api/Retailers/{id}/Carts/{cartId}/clearCart")
    Observable<Response<CartResponse>> clearCart(@Path("id") int retailerId, @Path("cartId") int cartId, @Body CartRequest request);

    @POST("api/Retailers/{id}/Carts/{cartId}/placeOrder")
    Observable<Response<OrderResponse>> placeOrder(@Path("id") int retailerId, @Path("cartId") int cartId, @Body CartRequest request);

    @GET("/api/Retailers/{id}/fetchMyOrderGroups/{offset}/{limit}")
    Observable<Response<List<OrderGroup>>> getOrders(@Path("id") int retailerId,
                                                     @Path("offset") int offset,
                                                     @Path("limit") int limit,
                                                     @QueryMap Map<String, String> query);

    @GET("/api/Retailers/{id}/fetchMyDistributors")
    Observable<Response<List<Distributor>>> fetchDistributors(@Path("id") int retailerId);

    @GET("api/Retailers/{id}/Distributors/{distributorId}/Products/search/{searchTerm}")
    Observable<Response<List<DistributorResponse>>> searchDistributorProducts(@Path("id") int retailerId, @Path("distributorId") int distributorId, @Path("searchTerm") String searchTerm);

    @GET("/api/Retailers/{id}/fetchMyDistributors")
    Observable<Response<List<Distributor>>> fetchDistributors(@Path("id") int retailerId, @Query(value = "filter", encoded = true) String request);

    @GET("/api/Payments/retailers/{id}/invoices")
    Observable<Response<PaymentsBasicResponse>> fetchInvoices(@Path("id") int retailerId);

    @POST("/api/Payments/retailers/{id}/invoices/bulkPay")
    Observable<Response<PaymentsBasicResponse>> bulkPayments(@Path("id") int retailerId, @Body List<BulkPayInvoice> invoices);

    @POST("/api/Payments/retailers/{id}/invoices/bulkPay")
    Observable<Response<PaymentsBasicResponse>> bulkPayments(@Path("id") int retailerId, @Body List<BulkPayInvoice> invoices, @Query(value = "verificationCode", encoded = true) long verificationCode);

    @GET("/api/Payments/retailers/{id}/invoices")
    Observable<Response<PaymentsBasicResponse>> fetchInvoicesByStatus(@Path("id") int retailerId, @Query("search") String search, @Query("size") int size);

    @POST("api/OMSUsers/{id}/registerDevice")
    Observable<Response<PushResponse>> registerDevice(@Path("id") long omsUserId, @Body PushRequest request);

    @POST("api/OMSUsers/{id}/deRegisterDevice")
    Observable<Response<PushResponse>> deRegisterDevice(@Path("id") long omsUserId, @Body PushCloseRequest request);

    @POST("/api/Payments/retailers/{id}/paymentRequest")
    Observable<Response<BasicResponse>> requestActivation(@Path("id") int retailerId);*/

}

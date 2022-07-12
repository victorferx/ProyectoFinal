package com.bootcamp.withdrawal.service.mapper;

import com.bootcamp.withdrawal.domain.Customer;
import com.bootcamp.withdrawal.web.model.CustomerModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-12T15:19:35-0500",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 1.4.100.v20220318-0906, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerModelToCustomer(CustomerModel model) {
        if ( model == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.email( model.getEmail() );
        customer.id( model.getId() );
        customer.identityCard( model.getIdentityCard() );
        customer.lastName( model.getLastName() );
        customer.name( model.getName() );
        customer.phoneNumber( model.getPhoneNumber() );

        return customer.build();
    }

    @Override
    public CustomerModel customerToCustomerModel(Customer domain) {
        if ( domain == null ) {
            return null;
        }

        CustomerModel customerModel = new CustomerModel();

        customerModel.setEmail( domain.getEmail() );
        customerModel.setId( domain.getId() );
        customerModel.setIdentityCard( domain.getIdentityCard() );
        customerModel.setLastName( domain.getLastName() );
        customerModel.setName( domain.getName() );
        customerModel.setPhoneNumber( domain.getPhoneNumber() );

        return customerModel;
    }

    @Override
    public List<CustomerModel> customersToCustomerModels(List<Customer> domain) {
        if ( domain == null ) {
            return null;
        }

        List<CustomerModel> list = new ArrayList<CustomerModel>( domain.size() );
        for ( Customer customer : domain ) {
            list.add( customerToCustomerModel( customer ) );
        }

        return list;
    }

    @Override
    public void update(Customer entity, CustomerModel updateEntity) {
        if ( updateEntity == null ) {
            return;
        }

        entity.setEmail( updateEntity.getEmail() );
        entity.setIdentityCard( updateEntity.getIdentityCard() );
        entity.setLastName( updateEntity.getLastName() );
        entity.setName( updateEntity.getName() );
        entity.setPhoneNumber( updateEntity.getPhoneNumber() );
    }
}

import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { OnlineStoreProductModule } from './product/product.module';
import { OnlineStoreProductCategoryModule } from './product-category/product-category.module';
import { OnlineStoreCustomerModule } from './customer/customer.module';
import { OnlineStoreProductOrderModule } from './product-order/product-order.module';
import { OnlineStoreOrderItemModule } from './order-item/order-item.module';
import { OnlineStoreInvoiceModule } from './invoice/invoice.module';
import { OnlineStoreShipmentModule } from './shipment/shipment.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        OnlineStoreProductModule,
        OnlineStoreProductCategoryModule,
        OnlineStoreCustomerModule,
        OnlineStoreProductOrderModule,
        OnlineStoreOrderItemModule,
        OnlineStoreInvoiceModule,
        OnlineStoreShipmentModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OnlineStoreEntityModule {}

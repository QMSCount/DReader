package com.duokan.reader.common.webservices.duokan;

import java.util.Comparator;

/* renamed from: com.duokan.reader.common.webservices.duokan.w */
final class C0649w implements Comparator<DkStoreFictionCategoryInfo> {
    C0649w() {
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m3044a((DkStoreFictionCategoryInfo) obj, (DkStoreFictionCategoryInfo) obj2);
    }

    /* renamed from: a */
    public int m3044a(DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo, DkStoreFictionCategoryInfo dkStoreFictionCategoryInfo2) {
        if (dkStoreFictionCategoryInfo.mLabel.length() < dkStoreFictionCategoryInfo2.mLabel.length()) {
            return -1;
        }
        if (dkStoreFictionCategoryInfo.mLabel.length() > dkStoreFictionCategoryInfo2.mLabel.length()) {
            return 1;
        }
        return 0;
    }
}

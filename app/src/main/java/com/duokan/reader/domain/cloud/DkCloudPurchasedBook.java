package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.DkCloudPurchasedBookInfo;
import com.duokan.reader.common.webservices.duokan.DkStoreBookSourceType;
import com.duokan.reader.domain.cloud.DkCloudBook.DkCloudBookFormat;

public class DkCloudPurchasedBook extends DkCloudStoreBook {
    private DkCloudRedeemBenefit mBenefit;
    private final DkCloudPurchasedBookInfo mBookInfo;
    private boolean mHasFullData;
    private String[][] mLabels;

    protected DkCloudPurchasedBook(DkCloudPurchasedBookInfo dkCloudPurchasedBookInfo) {
        super(dkCloudPurchasedBookInfo.mBookUuid);
        this.mLabels = (String[][]) null;
        this.mBenefit = null;
        this.mBookInfo = dkCloudPurchasedBookInfo;
        this.mHasFullData = true;
    }

    protected DkCloudPurchasedBook(C0845e c0845e) {
        super(c0845e.f3901a);
        this.mLabels = (String[][]) null;
        this.mBenefit = null;
        this.mBookInfo = new DkCloudPurchasedBookInfo();
        this.mBookInfo.mBookUuid = c0845e.f3901a;
        this.mBookInfo.mTitle = c0845e.f3902b;
        this.mBookInfo.mAuthors = c0845e.f3903c;
        this.mBookInfo.mEditors = c0845e.f3904d;
        this.mBookInfo.mOrderUuid = c0845e.f3905e;
        this.mBookInfo.mType = c0845e.f3906f;
        this.mBookInfo.setPurchaseTimeInSeconds(c0845e.f3907g);
        this.mBookInfo.mUpdateTime = c0845e.f3908h;
        this.mBookInfo.mCoverUri = c0845e.f3909i;
        this.mBookInfo.mIsHide = c0845e.f3910j;
        this.mHasFullData = false;
    }

    protected DkCloudPurchasedBook(DkCloudPurchasedBook dkCloudPurchasedBook) {
        super((DkCloudStoreBook) dkCloudPurchasedBook);
        this.mLabels = (String[][]) null;
        this.mBenefit = null;
        this.mBookInfo = new DkCloudPurchasedBookInfo(dkCloudPurchasedBook.mBookInfo);
        this.mLabels = dkCloudPurchasedBook.mLabels;
        this.mBenefit = dkCloudPurchasedBook.mBenefit;
        this.mHasFullData = dkCloudPurchasedBook.mHasFullData;
    }

    public boolean hasFullData() {
        return this.mHasFullData;
    }

    public String getBookUuid() {
        return this.mBookInfo.mBookUuid;
    }

    public String getTitle() {
        return this.mBookInfo.mTitle;
    }

    public DkCloudBookFormat getBookType() {
        return DkCloudBookFormat.EPUB;
    }

    public String[][] getLabels() {
        if (this.mLabels == null) {
            if (this.mBookInfo.mLabels == null || this.mBookInfo.mLabels.length < 1) {
                this.mLabels = FALLBACK_LABELS;
            } else {
                int i;
                int i2 = 0;
                for (String[] labelLevels : this.mBookInfo.mLabels) {
                    i2 = Math.max(labelLevels(labelLevels), i2);
                }
                if (i2 == 0) {
                    this.mLabels = FALLBACK_LABELS;
                } else {
                    for (i = 0; i < this.mBookInfo.mLabels.length; i++) {
                        if (labelLevels(this.mBookInfo.mLabels[i]) == 1) {
                            this.mBookInfo.mLabels[i] = new String[]{this.mBookInfo.mLabels[i][0], ""};
                        }
                    }
                }
                this.mLabels = this.mBookInfo.mLabels;
            }
        }
        return this.mLabels;
    }

    protected DkCloudItem merge(DkCloudItem dkCloudItem) {
        try {
            DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) dkCloudItem;
            DkCloudItem dkCloudPurchasedBook2 = new DkCloudPurchasedBook(this);
            dkCloudPurchasedBook2.mBookInfo.setPurchaseTimeInSeconds(dkCloudPurchasedBook.getPurchaseTimeInSeconds());
            dkCloudPurchasedBook2.mBookInfo.mUpdateTime = dkCloudPurchasedBook.mBookInfo.mUpdateTime;
            dkCloudPurchasedBook2.mBookInfo.mIsHide = dkCloudPurchasedBook.mBookInfo.mIsHide;
            dkCloudPurchasedBook2.mBenefit = dkCloudPurchasedBook.mBenefit;
            return dkCloudPurchasedBook2;
        } catch (Throwable th) {
            th.printStackTrace();
            return this;
        }
    }

    public String getCoverUri() {
        return this.mBookInfo.mCoverUri;
    }

    public String[] getAuthors() {
        return this.mBookInfo.mAuthors;
    }

    public String[] getEditors() {
        return this.mBookInfo.mEditors;
    }

    public String getAuthorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mBookInfo.mAuthors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public String getEditorLine() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : this.mBookInfo.mEditors) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(" ");
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public DkStoreBookSourceType getBookSourceType() {
        return this.mBookInfo.mType;
    }

    public boolean hasAd() {
        return this.mBookInfo.mAd;
    }

    public boolean markGifted() {
        if (this.mBookInfo.mType != DkStoreBookSourceType.GIFT) {
            return false;
        }
        this.mBookInfo.mType = DkStoreBookSourceType.GIFTED;
        return true;
    }

    public void setBookSourceType(DkStoreBookSourceType dkStoreBookSourceType) {
        this.mBookInfo.mType = dkStoreBookSourceType;
    }

    public void setRedeemMessage(DkCloudRedeemBenefit dkCloudRedeemBenefit) {
        this.mBenefit = dkCloudRedeemBenefit;
    }

    public DkCloudRedeemBenefit getRedeemMessage() {
        return this.mBenefit;
    }

    public long getPurchaseTimeInSeconds() {
        return this.mBookInfo.getPurchaseTimeInSeconds();
    }

    protected long getUpdateTimeInSeconds() {
        return this.mBookInfo.mUpdateTime;
    }

    public boolean isHidden() {
        return this.mBookInfo.mIsHide;
    }

    public void setHidden(boolean z) {
        this.mBookInfo.mIsHide = z;
    }
}

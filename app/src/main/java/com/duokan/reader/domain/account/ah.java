package com.duokan.reader.domain.account;

import android.accounts.Account;

import com.duokan.reader.common.b.a;

class ah implements be {
    final /* synthetic */ a a;
    final /* synthetic */ b b;
    final /* synthetic */ MiAccount c;

    ah(MiAccount miAccount, a aVar, b bVar) {
        this.c = miAccount;
        this.a = aVar;
        this.b = bVar;
    }

    public void a(Account account, String str) {
        this.a.a("com.xiaomi", str);
        this.c.a.a(this.c);
        this.b.a(this.c);
    }

    public void b(Account account, String str) {
        this.b.a(this.c, str);
    }
}

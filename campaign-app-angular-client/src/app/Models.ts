export class Seller {
    id:        number;
    name:      string;
    funds:     number;
    campaigns: Campaign[];
}

export class Campaign {
    id:           number;
    name:         string;
    keywords:     Keyword[];
    bidAmount:    number;
    campaignFund: number;
    status:       string;
    town:         Town;
    radius:       number;
    sellerId:     number;
    sellerName:   string;
}

export class Keyword {
    id:      number;
    keyword: string;
}

export class Town {
    id:   number;
    name: string;
}

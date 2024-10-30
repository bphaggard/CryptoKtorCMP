package org.example.project.ktorapitestcmp.util

import ktorapitestcmp.composeapp.generated.resources.Res
import ktorapitestcmp.composeapp.generated.resources._1inch
import ktorapitestcmp.composeapp.generated.resources.aave
import ktorapitestcmp.composeapp.generated.resources.ada
import ktorapitestcmp.composeapp.generated.resources.algo
import ktorapitestcmp.composeapp.generated.resources.ape
import ktorapitestcmp.composeapp.generated.resources.atom
import ktorapitestcmp.composeapp.generated.resources.avax
import ktorapitestcmp.composeapp.generated.resources.bch
import ktorapitestcmp.composeapp.generated.resources.beam
import ktorapitestcmp.composeapp.generated.resources.bnb
import ktorapitestcmp.composeapp.generated.resources.bsv
import ktorapitestcmp.composeapp.generated.resources.btc
import ktorapitestcmp.composeapp.generated.resources.dai
import ktorapitestcmp.composeapp.generated.resources.doge
import ktorapitestcmp.composeapp.generated.resources.dot
import ktorapitestcmp.composeapp.generated.resources.etc
import ktorapitestcmp.composeapp.generated.resources.eth
import ktorapitestcmp.composeapp.generated.resources.fil
import ktorapitestcmp.composeapp.generated.resources.grt
import ktorapitestcmp.composeapp.generated.resources.icp
import ktorapitestcmp.composeapp.generated.resources.kcs
import ktorapitestcmp.composeapp.generated.resources.leo
import ktorapitestcmp.composeapp.generated.resources.link
import ktorapitestcmp.composeapp.generated.resources.ltc
import ktorapitestcmp.composeapp.generated.resources.matic
import ktorapitestcmp.composeapp.generated.resources.mkr
import ktorapitestcmp.composeapp.generated.resources.neo
import ktorapitestcmp.composeapp.generated.resources.qnt
import ktorapitestcmp.composeapp.generated.resources.ray
import ktorapitestcmp.composeapp.generated.resources.sol
import ktorapitestcmp.composeapp.generated.resources.stx
import ktorapitestcmp.composeapp.generated.resources.theta
import ktorapitestcmp.composeapp.generated.resources.trx
import ktorapitestcmp.composeapp.generated.resources.uni
import ktorapitestcmp.composeapp.generated.resources.usdc
import ktorapitestcmp.composeapp.generated.resources.usdt
import ktorapitestcmp.composeapp.generated.resources.vet
import ktorapitestcmp.composeapp.generated.resources.wbtc
import ktorapitestcmp.composeapp.generated.resources.xlm
import ktorapitestcmp.composeapp.generated.resources.xmr
import ktorapitestcmp.composeapp.generated.resources.xrp

val cryptoNameToImageMap = mapOf(
    "bitcoin" to Res.drawable.btc,
    "ethereum" to Res.drawable.eth,
    "tether" to Res.drawable.usdt,
    "binance-coin" to Res.drawable.bnb,
    "solana" to Res.drawable.sol,
    "usd-coin" to Res.drawable.usdc,
    "xrp" to Res.drawable.xrp,
    "dogecoin" to Res.drawable.doge,
    "tron" to Res.drawable.trx,
    "cardano" to Res.drawable.ada,
    "avalanche" to Res.drawable.avax,
    "chainlink" to Res.drawable.link,
    "bitcoin-cash" to Res.drawable.bch,
    "wrapped-bitcoin" to Res.drawable.wbtc,
    "polkadot" to Res.drawable.dot,
    "unus-sed-leo" to Res.drawable.leo,
    "litecoin" to Res.drawable.ltc,
    "multi-collateral-dai" to Res.drawable.dai,
    "uniswap" to Res.drawable.uni,
    "internet-computer" to Res.drawable.icp,
    "monero" to Res.drawable.xmr,
    "ethereum-classic" to Res.drawable.etc,
    "stellar" to Res.drawable.xlm,
    "stacks" to Res.drawable.stx,
    "polygon" to Res.drawable.matic,
    "aave" to Res.drawable.aave,
    "filecoin" to Res.drawable.fil,
    "vechain" to Res.drawable.vet,
    "cosmos" to Res.drawable.atom,
    "the-graph" to Res.drawable.grt,
    "theta" to Res.drawable.theta,
    "kucoin-token" to Res.drawable.kcs,
    "maker" to Res.drawable.mkr,
    "algorand" to Res.drawable.algo,
    "bitcoin-sv" to Res.drawable.bsv,
    "beam" to Res.drawable.beam,
    "apecoin" to Res.drawable.ape,
    "raydium" to Res.drawable.ray,
    "quant" to Res.drawable.qnt,
    "neo" to Res.drawable.neo,
    "1inch" to Res.drawable._1inch
)